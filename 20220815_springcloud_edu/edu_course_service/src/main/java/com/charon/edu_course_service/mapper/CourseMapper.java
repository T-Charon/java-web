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

}




