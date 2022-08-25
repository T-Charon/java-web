package com.charon.edu_course_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.charon.edu_course_service.mapper")
@SpringBootApplication
public class EduCourseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduCourseServiceApplication.class, args);
    }

}
