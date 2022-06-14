package com.blb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Charon
 * @Date 2022/6/11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String img;
    private int classId;

    public Student(int id, String name, int age, String sex, String img) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.img = img;
    }
}
