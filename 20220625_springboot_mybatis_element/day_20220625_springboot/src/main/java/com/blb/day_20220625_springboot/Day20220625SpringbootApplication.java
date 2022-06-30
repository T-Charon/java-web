package com.blb.day_20220625_springboot;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@SpringBootApplication
@MapperScan("com.blb.day_20220625_springboot.mapper")
public class Day20220625SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day20220625SpringbootApplication.class, args);
    }

}
