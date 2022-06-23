package com.blb.day20220622_springsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.blb.day20220622_springsecurity.mapper")
public class Day20220622SpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day20220622SpringsecurityApplication.class, args);
    }

}
