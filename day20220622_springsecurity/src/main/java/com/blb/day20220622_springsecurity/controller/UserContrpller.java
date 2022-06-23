package com.blb.day20220622_springsecurity.controller;

import com.blb.day20220622_springsecurity.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Charon
 * @Date 2022/6/22
 **/

@Controller
public class UserContrpller {


    @RequestMapping("login")
    public String toLogin(){
        return "login";
    }

}
