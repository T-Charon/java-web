package com.blb.mysql_promotion_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@MapperScan("com.blb.mysql_promotion_service.mapper")
@SpringBootApplication
public class MysqlPromotionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlPromotionServiceApplication.class, args);
    }

}
