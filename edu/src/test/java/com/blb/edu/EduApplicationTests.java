package com.blb.edu;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.edu.pojo.Course;
import com.blb.edu.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EduApplicationTests {
    @Autowired
    private CourseService courseService;

    @Test
    void contextCoursePage() {
        IPage<Course> courseIPage = courseService.coursePage(1,10);
        System.out.println(courseIPage.getRecords());
    }

}
