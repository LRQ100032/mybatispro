package com.pratice.mybatispro.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pratice.mybatispro.pojo.User;

public interface UserService  {

    //分页查询
    IPage<User> findPage(int page,int size);

}
