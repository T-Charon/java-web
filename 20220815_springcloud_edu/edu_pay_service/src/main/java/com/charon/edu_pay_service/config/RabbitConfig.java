package com.charon.edu_pay_service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Charon
 * @Date 2022/9/1
 **/
@Slf4j
@Configuration
public class RabbitConfig {
    public static final String ORDER_QUEUE_NAME = "demo.order.queue";
    public static final String ORDER_DEAD_LETTER_QUEUE_NAME = "demo.order.deadletter.queue";
    public static final String ORDER_DEAD_LETTER_KEY = "demo.order.deadletter.key";
    public static final String ORDER_QUEUE_KEY = "demo.order.queue.key";
    public static final String ORDER_EXCHANGE = "demo.order.exchange";
    public static final String ORDER_DEAD_LETTER_EXCHANGE = "demo.order.deadletter.exchange";

    //声明常规交换机
    @Bean
    public TopicExchange orderExchange(){
        return new TopicExchange(ORDER_EXCHANGE);
    }

    //声明死信交换机
    @Bean
    public TopicExchange deadletterExchange(){
        return new TopicExchange(ORDER_DEAD_LETTER_EXCHANGE);
    }

    //声明常规业务队列
    @Bean
    public Queue orderQueue(){
        Map<String,Object> args = new HashMap<>();
        //设置死信交换机
        args.put("x-dead-letter-exchange",ORDER_DEAD_LETTER_EXCHANGE);
        //设置消息超时
//        args.put("x-message-ttl", 30 * 1000);
        //设置死信路由键
        args.put("x-dead-letter-routing-key",ORDER_DEAD_LETTER_KEY);
        return QueueBuilder.durable(ORDER_QUEUE_NAME).withArguments(args).build();
    }

    //死信队列
    @Bean
    public Queue orderDeadletterQueue(){
        return new Queue(ORDER_DEAD_LETTER_QUEUE_NAME);
    }

    //绑定订单交换机和订单队列
    @Bean
    public Binding bindOrderQueueExchange(){
        return BindingBuilder.bind(orderQueue()).to(orderExchange()).with(ORDER_QUEUE_KEY);
    }

    //绑定死信交换机和死信队列
    @Bean
    public Binding bindDeadLetterQueueExchange(){
        return BindingBuilder.bind(orderDeadletterQueue()).to(deadletterExchange()).with(ORDER_DEAD_LETTER_KEY);
    }
}