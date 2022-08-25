package com.charon.edu_course_service.controlller;

import com.charon.comment.entity.Course;
import com.charon.edu_course_service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/8/22
 **/
@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 获取所有课程数据（建立索引）
     * @return
     */
    @GetMapping("/getAllCourse")
    List<Course> getAllCourse() {

        return courseService.getAllCourse();
    }


}
