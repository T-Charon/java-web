package com.blb.thymeleaf.mapper;

import com.blb.thymeleaf.entity.User;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

/**
 * @Author Charon
 * @Date 2022/6/21
 **/

@Component
public interface UserMapper {

    /**
     * 登录功能，根据名字判断用户是否存在
     * @param name
     * @return
     */
    User getByName(String name);

}
