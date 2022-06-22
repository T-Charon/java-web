package com.blb.thymeleaf.service;

import com.blb.thymeleaf.entity.User;
import com.blb.thymeleaf.mapper.UserMapper;

import org.springframework.stereotype.Service;

/**
 * @Author Charon
 * @Date 2022/6/21
 **/


public interface IUserService {
    /**
     * 登录功能
     * @param name
     * @return
     */
    User getByName(String name);
}
