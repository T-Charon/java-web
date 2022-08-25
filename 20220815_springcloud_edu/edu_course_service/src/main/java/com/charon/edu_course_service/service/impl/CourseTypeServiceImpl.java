package com.charon.edu_course_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.charon.comment.entity.CourseType;
import com.charon.edu_course_service.mapper.CourseTypeMapper;
import com.charon.edu_course_service.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class CourseTypeServiceImpl extends ServiceImpl<CourseTypeMapper, CourseType>
    implements CourseTypeService{

    @Autowired
    private CourseTypeMapper courseTypeMapper;
    @Override
    public List<CourseType> getListCourseType() {
        return list();
    }
}




