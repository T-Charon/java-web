package com.charon.edu_pay_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.charon.edu_pay_service.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class EduPayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduPayServiceApplication.class, args);
    }

}
