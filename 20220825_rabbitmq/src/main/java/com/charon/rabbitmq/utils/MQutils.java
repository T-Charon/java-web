package com.charon.rabbitmq.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/25
 * 工具类
 **/
public class MQutils {
        public static final String QUEUE_NAME = "QUEUES01";

    /**
     * 获得连接
     * @return
     */
    public static Connection getConnection() throws IOException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("myhost");
        connectionFactory.setUsername("lzy");
        connectionFactory.setPassword("lzy");
        return connectionFactory.newConnection();
    }
}

