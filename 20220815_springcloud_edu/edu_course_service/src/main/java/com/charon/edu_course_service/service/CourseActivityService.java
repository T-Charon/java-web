package com.charon.edu_course_service.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.charon.comment.entity.CourseActivity;

/**
 *
 */
public interface CourseActivityService extends IService<CourseActivity> {
    /**
     * 修改库存
     * @param activityId 活动商品id
     * @param num 增减库存数量
     * @return
     */

    Boolean changeStock(Long activityId,Long num);

}
