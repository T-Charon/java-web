package com.blb.edu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.edu.pojo.Course;
import com.blb.edu.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Charon
 * @Date 2022/8/1
 **/

@RestController
@Api(tags = "课程管理")
@CrossOrigin
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;


    @ApiOperation("分页查询课程信息")
    @GetMapping("page")
    public ResponseEntity<IPage<Course>> getCourse(int current, int size){
        IPage<Course> courseIPage = courseService.coursePage(current, size);
        return ResponseEntity.ok(courseIPage);

    };

}
