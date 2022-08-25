package com.charon.edu_course_service.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.charon.comment.entity.Course;

import java.util.List;

/**
 *
 */
public interface CourseService extends IService<Course> {
    /**
     * 获取所有的课程信息
     * @return
     */
    List<Course> getAllCourse();

}
