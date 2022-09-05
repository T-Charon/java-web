package com.charon.edu_search_service.com.charon.listener;

import com.alibaba.fastjson.JSON;
import com.charon.comment.entity.Course;
import com.charon.edu_search_service.com.charon.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Message;

import com.rabbitmq.client.Channel;

/**
 * @Author Charon
 * @Date 2022/8/27
 * rabbitmq课程消息监听器
 **/
@Component
@Slf4j
public class CourseMsgListener {
    public static final String QUEUE_SAVE = "edu.course.save.queue";
    public static final String QUEUE_REMOVE = "edu.course.remove.queue";
    public static final String EXCHANGE_COURSE = "edu.course.exchange";
    public static final String KEY_SAVE = "edu.course.save.key";
    public static final String KEY_REMOVE = "edu.course.remove.key";

    @Autowired
    private  CourseService courseService;

    //监听添加或更新的队列
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = QUEUE_SAVE,durable = "true"),
            exchange = @Exchange(value = EXCHANGE_COURSE,ignoreDeclarationExceptions = "true"),
            key= KEY_SAVE))
    public void receiveSaveMsg(String json, Message message, Channel channel){
        //收到同步服务发送的课程对象
        Course course = JSON.parseObject(json, Course.class);
        courseService.savaOrUpdate(course);
        log.info("接收课程数据：{}",course);

    }

    //监听删除操作的队列
    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = QUEUE_REMOVE,durable = "true"),
            exchange = @Exchange(value = EXCHANGE_COURSE,ignoreDeclarationExceptions = "true"),
            key= KEY_REMOVE))
    public void receiveRemoveMsg(String id, Message message, Channel channel){
        //收到同步服务发送的需要删除的课程id

        courseService.removeById(id);
        log.info("接收需要删除的id：{}",id);

    }
}
