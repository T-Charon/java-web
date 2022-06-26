package com.blb.day_20220625_springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.day_20220625_springboot.entity.User;
import com.blb.day_20220625_springboot.mapper.UserMapper;
import com.blb.day_20220625_springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Charon
 * @Date 2022/6/25
 **/

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public IPage<User> getPage(Long current, Long size) {
        return userMapper.selectUserPage(new Page<>(current,size));
    }
}
