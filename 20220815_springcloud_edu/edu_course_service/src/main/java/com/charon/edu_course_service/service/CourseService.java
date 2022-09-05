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

    /**
     * 根据id获取课程信息
     * @param id
     * @return
     */
    Course getCourseInfoById(Long id);

    /**
     * 更新销量
     * @param id
     * @param sales
     * @return
     */
    Boolean updateCourse(Long id ,Integer sales);

}
