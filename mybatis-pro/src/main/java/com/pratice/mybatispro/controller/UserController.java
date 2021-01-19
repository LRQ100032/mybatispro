package com.pratice.mybatispro.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pratice.mybatispro.pojo.User;
import com.pratice.mybatispro.service.UserService;
import com.pratice.mybatispro.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    /*@Autowired
    private UserService userService;*/

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private IKeyGenerator keyGenerator;

    //分页查询
    @GetMapping(value = "/findPage/{currentPage}/{size}")
    public Map<String, Object> findPage(@PathVariable("currentPage") int currentPage, @PathVariable("size") int size) {
        //IPage<User> iPage = userService.findPage(page, size);
        HashMap<String, Object> resultMap = new HashMap<>();
        IPage<User> iPage = userServiceImpl.findPage(currentPage, size);
        List<User> records = iPage.getRecords();
        long total = iPage.getTotal();
        long pages = iPage.getPages();
        resultMap.put("total", total);
        resultMap.put("pages", pages);
        resultMap.put("rows", records);
        return resultMap;
    }

    //多条件分页查询
    @PostMapping(value = "/queryPage/{currentPage}/{size}")
    public Map<String, Object> findPage(@PathVariable int currentPage, @PathVariable int size, @RequestBody(required = false) User user) {
        HashMap<String, Object> resultMap = new HashMap<>();
        Page<User> userPage = new Page<>(currentPage, size);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        if (user != null) {
            if (!StringUtils.isEmpty(user.getName())) {
                userQueryWrapper.like("name", user.getName());
            }
            if (!StringUtils.isEmpty(user.getEmail())) {
                userQueryWrapper.eq("email", user.getEmail());
            }
        }
        Page<User> queryPages = userServiceImpl.page(userPage, userQueryWrapper);
        List<User> records = queryPages.getRecords();
        long total = queryPages.getTotal();
        long pages = queryPages.getPages();
        resultMap.put("total", total);
        resultMap.put("pages", pages);
        resultMap.put("rows", records);
        return resultMap;
    }


    //添加或修改用户
    @PostMapping(value = "/saveUser")
    public boolean saveUser(@RequestBody User user) {
        //如果id策略为INPUT,数据库表使用非自增主键,使用下面注释掉的代码
        //user.setId(IdWorker.getId());
        boolean result = userServiceImpl.saveOrUpdate(user);
        return result;
    }

    //根据id删除用户
    @GetMapping(value = "/deleteUser/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        boolean result = userServiceImpl.removeById(id);
        return result;
    }

    //根据id查找用户
    @GetMapping(value = "/findById/{id}")
    public User findById(@PathVariable Long id) {
        User byId = userServiceImpl.getById(id);
        return byId;
    }

    //根据多条件查找用户,支持模糊查询
    @PostMapping(value = "/queryUser")
    public List<User> queryUser(@RequestBody(required = false) User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        if (user != null) {
            if (!StringUtils.isEmpty(user.getName())) {
                userQueryWrapper.like("name", user.getName());
            }
            if (!StringUtils.isEmpty(user.getEmail())) {
                userQueryWrapper.eq("email", user.getEmail());
            }
        }
        List<User> list = userServiceImpl.list(userQueryWrapper);
        return list;
    }

    //查找所有用户
    @GetMapping
    public List<User> findAll() {
        List<User> allUser = userServiceImpl.list();
        return allUser;
    }


}
