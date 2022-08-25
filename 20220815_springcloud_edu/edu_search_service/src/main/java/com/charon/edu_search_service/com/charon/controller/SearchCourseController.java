package com.charon.edu_search_service.com.charon.controller;

import com.charon.comment.entity.Course;
import com.charon.edu_search_service.com.charon.entity.PageEntity;
import com.charon.edu_search_service.com.charon.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author Charon
 * @Date 2022/8/23
 **/
@Slf4j
@RestController
public class SearchCourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("search-course")
    public ResponseEntity<PageEntity<Course>> searchCoursePage(@RequestBody Map<String, String>args){
        log.info("search-course args:{}",args);
        PageEntity<Course> page = courseService.searchCoursePage(args);
        log.info("search-course page:{}",page);
        return ResponseEntity.ok(page);
    }
}
