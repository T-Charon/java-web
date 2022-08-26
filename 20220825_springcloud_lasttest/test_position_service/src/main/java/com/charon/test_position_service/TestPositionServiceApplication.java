package com.charon.test_position_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.charon.test_position_service.feign")
@MapperScan("com.charon.test_position_service.mapper")
@EnableDiscoveryClient
@SpringBootApplication
public class TestPositionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestPositionServiceApplication.class, args);
    }

}
