package com.charon.edu_course_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;import com.charon.comment.entity.CourseActivity;
import com.charon.edu_course_service.mapper.CourseActivityMapper;
import com.charon.edu_course_service.service.CourseActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Charon
 */
@Service
public class CourseActivityServiceImpl extends ServiceImpl<CourseActivityMapper, CourseActivity>
    implements CourseActivityService{

    @Autowired(required = false)
    private  CourseActivityMapper courseActivityMapper;
    /**
     * 修改库存
     * @param activityId 活动商品id
     * @param num 增减库存数量
     * @return
     */
    @Override
    public Boolean changeStock(Long activityId, Long num) {

        CourseActivity info = getById(activityId);
        Integer n = info.getStock();
        if(n > 0){
            return courseActivityMapper.changeStock(activityId,num);
        }
            return false;
    }
}




