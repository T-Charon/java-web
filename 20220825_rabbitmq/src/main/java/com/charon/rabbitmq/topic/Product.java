package com.charon.rabbitmq.topic;

import com.charon.rabbitmq.utils.MQutils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/25
 * 主题模式模式
 **/
public class Product {

    /**
     * 主题模式和路由模式差不多，在key中可以加入通配符：
     *  *匹配任意一个单词    com.*  ---->  com.hopu  com.blb  com.baidu
     *  #匹配.号隔开的多个单词 com.# ---> com.hopu.net  com.hopu com.163.xxx.xxx.xxx
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Connection connection = MQutils.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //direct exchange 参数一：交换机名称 参数二：类型
        channel.exchangeDeclare("exchange03","topic");

        String msg = "hello ";
        String msg1 = "Route";
        //绑定队列1到交换机,指定key
        channel.queueBind("myqueues01","exchange03","cn.*");
        //绑定队列2到交换机,指定key
        channel.queueBind("myqueues02","exchange03","#.com");
        //发布消息到交换机
        channel.basicPublish("exchange03","cn.123",null,msg.getBytes());
        channel.basicPublish("exchange03","blb.demo.com",null,msg1.getBytes());
        System.out.println("send"+msg);
        channel.close();
        connection.close();
    }
}
