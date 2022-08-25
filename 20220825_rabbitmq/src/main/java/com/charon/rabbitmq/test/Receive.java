package com.charon.rabbitmq.test;

import com.charon.rabbitmq.utils.MQutils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/25
 **/
public class Receive {
    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = MQutils.getConnection();
        Channel channel = connection.createChannel();
        //定义队列
        channel.queueDeclare(MQutils.QUEUE_NAME,false,false,false,null);
        //创建消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        //消费者消费通道中的消息
        channel.basicConsume(MQutils.QUEUE_NAME,true,queueingConsumer);
        //读取消息
        while(true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            System.out.println(new String(delivery.getBody()));
        }
    }
}
