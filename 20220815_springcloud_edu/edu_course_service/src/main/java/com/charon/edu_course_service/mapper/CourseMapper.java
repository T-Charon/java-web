package com.charon.edu_course_service.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.charon.comment.entity.Course;

import java.util.List;

/**
 * @Entity com.charon.edu_course_service.entity.Course
 */
public interface CourseMapper extends BaseMapper<Course> {
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




