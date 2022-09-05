package com.charon.edu_canal_service.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.charon.comment.entity.Course;
import com.charon.edu_canal_service.config.RabbitMQConfig;
import com.charon.edu_canal_service.feign.CourseFeignClient;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.ListenPoint;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/8/27
 * 监听mysql课程表的监听器
 **/
@CanalEventListener
public class CanalListener {
    @Autowired
    private CourseFeignClient courseFeignClient;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @ListenPoint(schema = "edu_course",table = "course")
    public void courseChange(CanalEntry.EventType eventType,CanalEntry.RowData rowData){
        //获得操作的类型
        String type = eventType.toString();
        if("INSERT".equals(type) || "UPDATE".equals(type)){
            List<CanalEntry.Column> list = rowData.getAfterColumnsList();
            //获得课程id那一列
            String id = null;
            for(CanalEntry.Column column : list){
                if("id".equals(column.getName())){
                    id = column.getValue();
                    break;
                }
            }
            //调用课程服务
            Course course = courseFeignClient.getCourseInfoById(Long.valueOf(id));
            //发送消息给搜索服务
            System.out.println(type+":"+course);
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_COURSE,RabbitMQConfig.KEY_SAVE, JSON.toJSONString(course));
        }else if("DELETE".equals(type)){
            List<CanalEntry.Column> list = rowData.getBeforeColumnsList();
            //获得课程id那一列
            String id = null;
            for(CanalEntry.Column column : list){
                if("id".equals(column.getName())){
                    id = column.getValue();
                    break;
                }
            }
            //发送消息给搜索服务
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_COURSE,RabbitMQConfig.KEY_REMOVE,id);
        }
    };
}
