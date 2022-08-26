package com.charon.test_dept_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.charon.test_dept_service.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class TestDeptServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestDeptServiceApplication.class, args);
    }

}
