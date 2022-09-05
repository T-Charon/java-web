package com.charon.edu_course_service.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.charon.comment.entity.CourseActivity;

/**
 * @Entity com.charon.edu_course_service.entity.CourseActivity
 */
public interface CourseActivityMapper extends BaseMapper<CourseActivity> {
    /**
     * 修改库存
     * @param activityId 活动商品id
     * @param num 增减库存数量
     * @return
     */
    Boolean changeStock(Long activityId,long num);

}




