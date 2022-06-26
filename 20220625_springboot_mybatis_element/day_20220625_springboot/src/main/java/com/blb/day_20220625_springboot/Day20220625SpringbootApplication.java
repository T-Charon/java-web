package com.blb.day_20220625_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blb.day_20220625_springboot.mapper")
public class Day20220625SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day20220625SpringbootApplication.class, args);
    }

}
