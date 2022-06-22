package com.blb.thymeleaf.controller;

import com.blb.thymeleaf.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/21
 **/

@Controller
public class DemoController {

    @GetMapping("hello")
    public String toHelloPage(Model model){
        List<Person> list = Arrays.asList(
                new Person("张三",25,"湖北"),
                new Person("李四",26,"湖南"),
                new Person("王五",27,"湖北")
        );
        model.addAttribute("persons",list);
        return "hello";
    }
}
