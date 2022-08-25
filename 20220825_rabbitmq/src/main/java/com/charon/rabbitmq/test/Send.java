package com.charon.rabbitmq.test;

import com.charon.rabbitmq.utils.MQutils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/25
 * 生产者，发送简单的消息队列
 **/
public class Send {
    public static void main(String[] args) throws IOException {
        Connection connection = MQutils.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //定义队列
        channel.queueDeclare(MQutils.QUEUE_NAME,false,false,false,null);
        String msg = "hello world";
        //发布消息
        channel.basicPublish("",MQutils.QUEUE_NAME,null,msg.getBytes());
        channel.close();
        connection.close();
    }
}
