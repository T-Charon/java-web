package com.charon.rabbitmq.direct;

import com.charon.rabbitmq.utils.MQutils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/25
 **/
public class Consumer02 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = MQutils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("myqueues02",false,false,false,null);
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        channel.basicConsume("myqueues02",true,queueingConsumer);
        while(true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            System.out.println("RouteConsumer2 receive :" + new String(delivery.getBody()));
        }
    }
}
