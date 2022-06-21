package com.blb.springboot.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author Charon
 * @Date 2022/6/20
 **/

@Component
@Data
public class Person {
    //@Value("${person.name}")
    private String name;
   // @Value("${person.age}")
    private Integer age;
   // @Value("${person.address}")
    private String address;
}
