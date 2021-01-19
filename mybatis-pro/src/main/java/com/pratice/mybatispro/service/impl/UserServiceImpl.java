package com.pratice.mybatispro.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pratice.mybatispro.mapper.UserMapper;
import com.pratice.mybatispro.pojo.User;
import com.pratice.mybatispro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> findPage(int page, int size) {
        Page<User> userPage = new Page<>(page,size);
        IPage<User> userIPage = userMapper.selectPageVo(userPage);
        return userIPage;
    }
}
