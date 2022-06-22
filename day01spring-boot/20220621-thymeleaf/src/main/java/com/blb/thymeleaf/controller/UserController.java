package com.blb.thymeleaf.controller;

import com.blb.thymeleaf.entity.Product;
import com.blb.thymeleaf.entity.User;
import com.blb.thymeleaf.service.IProductService;
import com.blb.thymeleaf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/21
 **/

@Controller
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping("")
    public String loginPage(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("login")
    public String loginIndex(String username,String password){
        User user = null;
        System.out.println(username);
        System.out.println(password);
        user = userService.getByName(username);
        if(user == null){
            return "1";
        }if(!password.equals(user.getPassword())){
            return "2";
        }else{
            System.out.println("成功！");
            return "ok";
        }
    }


}
