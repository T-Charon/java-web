package com.charon.edu_pay_service.feign;

import com.charon.comment.entity.UserCourseOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Charon
 * @Date 2022/8/31
 **/
@FeignClient("order-service")
public interface OrderClient {

    /**
     * 微信下单后调用新增订单
     * @param userCourseOrder
     * @return
     */
    @PostMapping("order/add")
    ResponseEntity<Boolean> savaOrder(UserCourseOrder userCourseOrder);

    /**
     * 支付成功调用修改订单状态
     * @param id
     * @param status
     * @return
     */
    @PutMapping("order/update")
    ResponseEntity<Boolean> updateOrder(@RequestParam  Long id, @RequestParam  Byte status);

    /**
     * 根据活动表id获取课程id
     * @param tradeNo
     * @return
     */
    @GetMapping("order/getCourse/{tradeNo}")
    ResponseEntity<UserCourseOrder>getById(@PathVariable Long tradeNo);

}
