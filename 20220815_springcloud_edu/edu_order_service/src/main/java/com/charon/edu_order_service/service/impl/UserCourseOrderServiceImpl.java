package com.charon.edu_order_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.charon.comment.entity.UserCourseOrder;
import com.charon.edu_order_service.mapper.UserCourseOrderMapper;
import com.charon.edu_order_service.service.UserCourseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserCourseOrderServiceImpl extends ServiceImpl<UserCourseOrderMapper, UserCourseOrder>
    implements UserCourseOrderService{

    @Autowired(required = false)
    private UserCourseOrderMapper userCourseOrderMapper;

    @Override
    public Boolean updateOrder(Long id, Byte status) {
        return userCourseOrderMapper.updateOrder(id,status);
    }
}




