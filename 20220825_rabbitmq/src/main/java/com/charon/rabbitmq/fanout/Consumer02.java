package com.charon.rabbitmq.fanout;

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
    /**
     * 发布订阅模式的消费者1
     *  两个消费者绑定的消息队列不同
     *  通过交换机一个消息能被不同队列的两个消费者同时获取
     *  一个队列可以有多个消费者，队列中的消息只能被一个消费者获取
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Connection connection = MQutils.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        channel.queueDeclare("myqueues02",false,false,false,null);
        //绑定队列1到交换机 参数一：队列名称 参数二：交换机名称
        channel.queueBind("myqueues02","exchange01","");
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        //消费者消费通道中的消息
        channel.basicConsume("myqueues02",true,queueingConsumer);

        while(true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            System.out.println("consumer02 receive:"+new String(delivery.getBody()));

        }
    }
}
