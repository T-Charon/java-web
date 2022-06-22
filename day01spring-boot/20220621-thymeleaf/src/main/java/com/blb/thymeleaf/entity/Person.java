package com.blb.thymeleaf.entity;

import lombok.Data;

/**
 * @Author Charon
 * @Date 2022/6/21
 **/


@Data
public class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
