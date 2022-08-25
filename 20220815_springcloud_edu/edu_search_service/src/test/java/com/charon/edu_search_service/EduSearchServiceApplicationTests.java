package com.charon.edu_search_service;

import com.charon.edu_search_service.com.charon.mapper.ElasticSearchDAO;
import com.charon.edu_search_service.com.charon.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
class EduSearchServiceApplicationTests {
    @Autowired
    CourseService courseService;

    @Autowired
    ElasticSearchDAO dao;
    @Test
    void contextLoads() throws IOException {
        courseService.initCourseIndex();
//        Map<String, String> map = new HashMap<>();
//        map.put("courseName","大数据");
//
//        PageEntity<Course> page = dao.searchPageByMap("course", 0, 100, map, null, Course.class, "courseName");
//        //PageEntity<Course> page = courseService.searchCoursePage(map);
//        System.out.println(page.getData());
    }

}
