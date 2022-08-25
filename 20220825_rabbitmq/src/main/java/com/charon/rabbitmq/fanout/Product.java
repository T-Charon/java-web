package com.charon.rabbitmq.fanout;

import com.charon.rabbitmq.utils.MQutils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/25
 * 发布订阅
 **/
public class Product {

    /**
     * 发布和订阅模式的生产者，消息会通过交换机发到队列
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Connection connection = MQutils.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明fanout exchange 参数一：交换机名称 参数二：类型
        channel.exchangeDeclare("exchange01","fanout");
        String msg = "hello Fanout";
        //发布消息到交换机
        channel.basicPublish("exchange01","",null,msg.getBytes());
        System.out.println("send"+msg);
        channel.close();
        connection.close();
    }
}
