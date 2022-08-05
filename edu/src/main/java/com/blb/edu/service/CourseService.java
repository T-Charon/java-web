package com.blb.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.edu.pojo.Course;

/**
 *
 */
public interface CourseService {
    IPage<Course> coursePage(int current,int page);
}
