package com.charon.edu_course_service;

import com.charon.comment.entity.Course;
import com.charon.edu_course_service.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EduCourseServiceApplicationTests {

    @Autowired
    private CourseService courseService;
    @Test
    void contextLoads() {
        List<Course> allCourse = courseService.getAllCourse();
        allCourse.forEach(System.out::println);
    }

//    @Test
//    void testCourseIndex() throws IOException {
//        courseService.initCourseIndex();
//    }
}


