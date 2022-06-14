package com.blb.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author Charon
 * @Date 2022/6/14
 **/

@MapperScan("com.blb.mapper")
@Configuration
@ComponentScan("com.blb")
public class AppConfig {


    //设置连接池
    @Bean
    public DataSource dataSource(){
            HikariDataSource hikariDataSource = new HikariDataSource();
            hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            hikariDataSource.setJdbcUrl("jdbc:mysql:///db1?serverTimezone=UTC");
            hikariDataSource.setUsername("root");
            hikariDataSource.setPassword("root");
            return hikariDataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }
}
