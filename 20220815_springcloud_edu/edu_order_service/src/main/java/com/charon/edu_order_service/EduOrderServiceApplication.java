package com.charon.edu_order_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@MapperScan("com.charon.edu_order_service.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class EduOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduOrderServiceApplication.class, args);
    }

}
