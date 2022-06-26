package com.blb.day_20220625_springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Charon
 * @Date 2022/6/23
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    //主键递增
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Long page;
}
