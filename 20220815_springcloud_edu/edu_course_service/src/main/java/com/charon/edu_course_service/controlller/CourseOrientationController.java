package com.charon.edu_course_service.controlller;

import com.charon.comment.entity.CourseOrientation;
import com.charon.edu_course_service.service.CourseOrientationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/8/19
 **/
@RestController
@RequestMapping("course-orientation")
public class CourseOrientationController {
    @Autowired
    private CourseOrientationService courseOrientationService;

    /**
     * 获取一级列表方法
     * @return
     */
    @GetMapping
    public ResponseEntity<List<CourseOrientation>> getListCourseOrientation(){

        return ResponseEntity.ok(courseOrientationService.getListCourseOrientation());
    }

    /**
     * 根据上级id获取下级课程方向
     * @param id
     * @return
     */
    @GetMapping("/parent/{id}")
    public ResponseEntity<List<CourseOrientation>> getListCourseOrientationChildren(@PathVariable Integer id){
        return ResponseEntity.ok(courseOrientationService.getListCourseOrientationChildren(id));
    }



}
