package com.blb.thymeleaf.service.impl;

import com.blb.thymeleaf.entity.User;
import com.blb.thymeleaf.mapper.UserMapper;
import com.blb.thymeleaf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Charon
 * @Date 2022/6/21
 **/

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private  UserMapper userMapper;

    @Override
    public User getByName(String name) {
        return userMapper.getByName(name);
    }
}
