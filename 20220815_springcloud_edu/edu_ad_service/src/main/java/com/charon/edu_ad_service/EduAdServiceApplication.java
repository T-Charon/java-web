package com.charon.edu_ad_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Charon
 */
@EnableCaching
@EnableDiscoveryClient
@MapperScan("com.charon.edu_ad_service.mapper")
@SpringBootApplication
public class EduAdServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduAdServiceApplication.class, args);
    }

}
