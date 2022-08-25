package com.charon.rabbitmq.direct;

import com.charon.rabbitmq.utils.MQutils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/25
 * 路由模式
 **/
public class Product {

    /**
     *  路由模式的生产者，发布消息会有特定的Key，消息会被绑定特定Key的消费者获取
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Connection connection = MQutils.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //direct exchange 参数一：交换机名称 参数二：类型
        channel.exchangeDeclare("exchange02","direct");

        String msg = "hello ";
        String msg1 = "Route";
        //绑定队列1到交换机,指定key为error
        channel.queueBind("myqueues01","exchange02","error");
        //绑定队列2到交换机,指定key为debug
        channel.queueBind("myqueues02","exchange02","debug");
        //发布消息到交换机
        channel.basicPublish("exchange02","error",null,msg.getBytes());
        channel.basicPublish("exchange02","debug",null,msg1.getBytes());
        System.out.println("send"+msg);
        channel.close();
        connection.close();
    }
}
