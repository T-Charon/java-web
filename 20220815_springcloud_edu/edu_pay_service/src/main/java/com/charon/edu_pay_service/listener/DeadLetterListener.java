package com.charon.edu_pay_service.listener;

import com.charon.comment.entity.UserCourseOrder;
import com.charon.edu_pay_service.config.RabbitConfig;
import com.charon.edu_pay_service.feign.CourseActivityClient;
import com.charon.edu_pay_service.feign.OrderClient;
import com.charon.edu_pay_service.service.WXPayService;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author Charon
 * @Date 2022/9/1
 **/
@Slf4j
@Component
public class DeadLetterListener {
    @Autowired
    private WXPayService wxPayService;

    @Autowired
    private CourseActivityClient courseActivityClient;

    @Autowired
    private OrderClient orderClient;

    //处理死信消息
    @RabbitListener(queues = RabbitConfig.ORDER_DEAD_LETTER_QUEUE_NAME)
    public void receiveDeadLetterOrder(Message message, Channel channel) throws Exception {
        String messageId = message.getMessageProperties().getMessageId();
        String order = new String(message.getBody());
        log.info("接收死信! id:{},order:{}",messageId,order);
        //查询数据库订单状态
        if(wxPayService.checkWxOrder(messageId).equals("NOTPAY")){
            //更新订单状态（2===>已取消）
            orderClient.updateOrder(Long.valueOf(messageId),(byte)2);
            //根据订单id查询活动Id
            UserCourseOrder info = orderClient.getById(Long.valueOf(messageId)).getBody();
            //根据活动id更新库存
            courseActivityClient.changeStock(info.getActivityId(),1);
            log.info("30秒未支付，取消订单{}，库存+1");
            //关闭订单
            wxPayService.doOrderClose(messageId);
            log.info("远程订单已关闭{}");
        }
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }
}
