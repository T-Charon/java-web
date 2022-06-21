package com.blb.springboot.controller;

import com.blb.springboot.entity.Person;
import com.blb.springboot.entity.PersonProp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Charon
 * @Date 2022/6/20
 **/

@RestController
public class DemoController {
    @RequestMapping("hello")
    public String hello(){
        return "你好 spring-boot";
    }


    //注入实体类
    @Autowired
    Person person;
    @RequestMapping("")
    public Person hello1(){
        return person;
    }

    @Autowired
    PersonProp personprop;
    @RequestMapping("person")
    public PersonProp hello2(){
        return personprop;
    }

}
