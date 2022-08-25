package com.charon.edu_course_service.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.charon.comment.entity.CourseType;

import java.util.List;

/**
 *
 */
public interface CourseTypeService extends IService<CourseType> {
    /**
     * 查询所有课程类型
     * @return
     */
    List<CourseType> getListCourseType();
}
