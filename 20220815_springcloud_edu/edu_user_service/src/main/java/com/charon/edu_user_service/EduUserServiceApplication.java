package com.charon.edu_user_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.charon.edu_user_service.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class EduUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduUserServiceApplication.class, args);
    }

}
