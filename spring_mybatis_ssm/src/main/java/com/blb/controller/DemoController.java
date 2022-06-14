package com.blb.controller;

import com.blb.entity.User;
import com.blb.mapper.UserMapperDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/14
 **/

@Controller
public class DemoController {
    @Autowired
    UserMapperDao userMapperDao;

    @ResponseBody
    @GetMapping("")
    public String hello(){
        return "你好 spring mvc";
    }

    @ResponseBody
    @GetMapping("hello1")
    public List<User> hello1(){
        return userMapperDao.list();
    }

    @GetMapping("hello2")
    public String hello2(){
        return "index";
    }
}
