package com.pratice.mybatispro;


import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pratice.mybatispro.mapper.UserMapper;
import com.pratice.mybatispro.pojo.User;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

class Animal {

    static {
        System.out.println("动物类被加载");
    }

    public Animal() {
        System.out.println("我是动物");
    }

    public void eat() {
        System.out.println("动物吃饭");
    }
}

class Dog extends Animal {

    static {
        System.out.println("狗类被加载");
    }

    public Dog() {
        System.out.println("我是狗");
    }

    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void work() {
        System.out.println("狗看家");
    }
}

@SpringBootTest
public class MybatisproApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IdentifierGenerator identifierGenerator;

    @Autowired
    private IKeyGenerator iKeyGenerator;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelect2() {
        //当前页,每页大小
        Page<User> userPage = new Page<>(2, 2);
        IPage<User> userIPage = userMapper.selectPageVo(userPage);
        long total = userIPage.getPages();
        List<User> records = userIPage.getRecords();
        for (User record : records) {
            System.out.println(record.toString());
        }
        System.out.println(total);
    }

    @Test
    void testCustomId() {
        Number number = identifierGenerator.nextId(new User());
        System.out.println(number);
    }


    @Test
    void duotaiTest() {
        Animal ani = new Dog();
        ani.eat();
        ani = new Dog();

    }

    @Test
    void listTest() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User((long) i, "a" + i, i % 2, "a" + i + "@gmail.com");
            users.add(user);
        }

        HashMap<Integer, List<User>> classMap = new HashMap<>();
        for (User user : users) {
            Integer age = user.getAge();
            List<User> userExample = classMap.get(age);
            if (userExample == null) {
                ArrayList<User> userList = new ArrayList<>();
                userList.add(user);
                classMap.put(age, userList);
            } else {
                userExample.add(user);
            }
        }

        Set<Map.Entry<Integer, List<User>>> entries = classMap.entrySet();
        for (Map.Entry<Integer, List<User>> entry : entries) {
            System.out.println(entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user.toString());
            }
        }
    }
}
