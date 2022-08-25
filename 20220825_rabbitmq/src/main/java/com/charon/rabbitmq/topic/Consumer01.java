package com.charon.rabbitmq.topic;

import com.charon.rabbitmq.utils.MQutils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/25
 **/
public class Consumer01 {


    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = MQutils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("myqueues01",false,false,false,null);
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        channel.basicConsume("myqueues01",true,queueingConsumer);
        while(true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            System.out.println("RouteConsumer1 receive :" + new String(delivery.getBody()));
        }
    }
}
