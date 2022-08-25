package com.charon.rabbitmq.work;

import com.charon.rabbitmq.utils.MQutils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/25
 * 工作队列
 **/
public class Product {

    /**
     * 多对多模式中的生产者
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Connection connection = MQutils.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        channel.queueDeclare(MQutils.QUEUE_NAME,false,false,false,null);
        for (int i = 0; i < 10; i++) {
            String msg = "hello-->"+i;
            channel.basicPublish("",MQutils.QUEUE_NAME,null ,msg.getBytes());
            System.out.println("send:"+msg);
        }
        channel.close();
        connection.close();
    }
}
