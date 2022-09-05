package com.charon.edu_course_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.charon.comment.entity.Course;
import com.charon.edu_course_service.mapper.CourseMapper;
import com.charon.edu_course_service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Charon
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{
    @Autowired(required = false)
    private CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourse() {
        return courseMapper.getAllCourse();
    }

    @Override
    public Course getCourseInfoById(Long id) {
        return courseMapper.getCourseInfoById(id);
    }

    @Override
    public Boolean updateCourse(Long id, Integer sales) {
        return courseMapper.updateCourse(id,sales);
    }
}




