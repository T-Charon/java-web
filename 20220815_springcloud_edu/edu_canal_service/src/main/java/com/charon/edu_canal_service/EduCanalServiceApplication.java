package com.charon.edu_canal_service;

import com.xpand.starter.canal.annotation.EnableCanalClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@EnableCanalClient
@EnableFeignClients("com.charon.edu_canal_service.feign")
@SpringBootApplication
public class EduCanalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduCanalServiceApplication.class, args);
    }

}
