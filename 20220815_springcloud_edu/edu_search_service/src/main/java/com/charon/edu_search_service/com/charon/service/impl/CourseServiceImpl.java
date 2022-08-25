package com.charon.edu_search_service.com.charon.service.impl;

import com.alibaba.fastjson.JSON;
import com.charon.comment.entity.Course;
import com.charon.edu_search_service.com.charon.entity.ElasticEntity;
import com.charon.edu_search_service.com.charon.entity.PageEntity;
import com.charon.edu_search_service.com.charon.feign.CourseFeign;
import com.charon.edu_search_service.com.charon.mapper.ElasticSearchDAO;
import com.charon.edu_search_service.com.charon.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author Charon
 * @Date 2022/8/22
 **/
@Slf4j
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private ElasticSearchDAO dao;

    @Autowired
    private CourseFeign courseFeign;

    @Override
    public List<Course> initCourseIndex(){
        try {
            //存在先删除索引
            if(dao.existsIndex(INDEX_NAME)) {
                dao.deleteIndex(INDEX_NAME);
            }
            //创建索引
            dao.createIndex(INDEX_NAME);
            //调用课程服务获得全部课程
            List<Course> allCourse = courseFeign.getAllCourse();
            List<ElasticEntity> list = new ArrayList<>();
            allCourse.forEach(course -> {
                list.add(new ElasticEntity(String.valueOf(course.getId()),course));
            });
            //批量插入ES索引中
            dao.insertBatch(INDEX_NAME,list);
            return allCourse;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public PageEntity<Course> searchCoursePage(Map<String, String> map) {
        int current = 1;
        int size = 10;
        Map search = null;
        Map sort = null;

        if(map.containsKey("current")){
            current = Integer.parseInt(map.get("current"));
        }
        if(map.containsKey("size")){
            size = Integer.parseInt(map.get("size"));
        }
        if(map.containsKey("search")){
            search = JSON.parseObject(map.get("search"),Map.class);
        }
        if(map.containsKey("sort")){
            sort = JSON.parseObject(map.get("sort"),Map.class);
        }

        try {
            return dao.searchPageByMap(INDEX_NAME, (current - 1) * size, size, search, sort, Course.class,"courseName","brief");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
