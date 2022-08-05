package com.blb.edu.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blb.edu.mapper.CourseMapper;
import com.blb.edu.pojo.Course;
import com.blb.edu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public IPage<Course> coursePage(int current, int page) {
        return courseMapper.getCoursePage(new Page<>(current,page));
    }
}




