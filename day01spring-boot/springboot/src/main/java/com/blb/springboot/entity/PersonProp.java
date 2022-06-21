package com.blb.springboot.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author Charon
 * @Date 2022/6/20
 **/

@Data
@Component
@ConfigurationProperties(prefix = "personprop")
public class PersonProp {
    private String name;
    private Integer age;
    private Map<String,Object> address;
    private List<String> hobbies;
}
