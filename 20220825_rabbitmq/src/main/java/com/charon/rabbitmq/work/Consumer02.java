package com.charon.rabbitmq.work;

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
     * 实现能者多劳：
     * 1. channel.basicQos(1);限制队列一次发一个消息给消费者，等消费者有了反馈，再发下一条
     * 2. channel.basicAck 消费完消息后手动反馈，处理快的消费者就能处理更多消息
     * 3. basicConsume 中的参数改为false
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        Connection connection = MQutils.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        channel.queueDeclare(MQutils.QUEUE_NAME,false,false,false,null);
        //能者多劳模式--->①同一时刻服务器只发送一条消息给消费者
        channel.basicQos(1);
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        //消费者消费通道中的消息
        //能者多劳模式--->②true是自动返回完成状态，false表示手动
        channel.basicConsume(MQutils.QUEUE_NAME,false,queueingConsumer);

        while(true){
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            System.out.println("consumer02 receive:"+new String(delivery.getBody()));
            Thread.sleep(100);
            //能者多劳模式--->③手动返回确定状态，不写就是自动确认
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
        }
    }
}
