package com.charon.edu_order_service.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.charon.comment.entity.UserCourseOrder;

/**
 *
 */
public interface UserCourseOrderService extends IService<UserCourseOrder> {
    Boolean updateOrder(Long id,Byte status);
}
