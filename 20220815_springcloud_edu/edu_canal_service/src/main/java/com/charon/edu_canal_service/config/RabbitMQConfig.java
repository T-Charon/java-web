package com.charon.edu_canal_service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;

/**
 * @Author Charon
 * @Date 2022/8/27
 **/
@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_SAVE = "edu.course.save.queue";
    public static final String QUEUE_REMOVE = "edu.course.remove.queue";
    public static final String EXCHANGE_COURSE = "edu.course.exchange";
    public static final String KEY_SAVE = "edu.course.save.key";
    public static final String KEY_REMOVE = "edu.course.remove.key";

    //生成队列
    @Bean
    public Queue queueSave(){
        return  new Queue(QUEUE_SAVE);
    }
    @Bean
    public Queue queueRemove(){
        return  new Queue(QUEUE_REMOVE);
    };
    //生成交换机
    @Bean
    public TopicExchange exchange(){
        return  new TopicExchange(EXCHANGE_COURSE);
    };
    //生成绑定
    @Bean
    public Binding bindingSave(){
        return BindingBuilder.bind(queueSave()).to(exchange()).with(KEY_SAVE);
    }
    @Bean
    public Binding bindingRemove(){
        return BindingBuilder.bind(queueRemove()).to(exchange()).with(KEY_REMOVE);
    }
}
