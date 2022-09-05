package com.charon.edu_search_service.com.charon.service;

import com.charon.comment.entity.Course;
import com.charon.edu_search_service.com.charon.entity.PageEntity;

import java.util.List;
import java.util.Map;

/**
 * @Author Charon
 * @Date 2022/8/22
 **/
public interface CourseService {
    String INDEX_NAME = "course";

    /**
     * 初始化索引
     * @return
     */
    List<Course> initCourseIndex();

    /**
     * 查询
     * @param map
     * @return
     */
    PageEntity<Course>searchCoursePage(Map<String,String>map);

    /**
     * 添加或更新课程
     * @param course
     */
    void savaOrUpdate(Course course);

    /**
     * 按id删除课程
     * @param id
     */
    void removeById(String id);
}
