package com.charon.edu_course_service.controlller;

import com.charon.comment.entity.CourseType;
import com.charon.edu_course_service.service.CourseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/8/19
 **/
@RestController
@RequestMapping("course-types")
public class CourseTypeController {


    @Autowired
    private CourseTypeService courseTypeService;

    /**
     * 获取所有课程类型
     * @return
     */
    @GetMapping
    public ResponseEntity<List<CourseType>> getListCourseType(){

        return ResponseEntity.ok(courseTypeService.getListCourseType());
    }
}
