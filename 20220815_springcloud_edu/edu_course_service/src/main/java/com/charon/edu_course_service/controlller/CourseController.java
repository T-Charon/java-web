package com.charon.edu_course_service.controlller;

import com.charon.comment.entity.Course;
import com.charon.edu_course_service.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 根据id获取课程信息（canal监控数据库是否被修改）
     * @param id
     * @return
     */
    @GetMapping("/getCourseInfoById/{id}")
    Course getCourseInfoById(@PathVariable Long id){
        return courseService.getCourseInfoById(id);
    }


    /**
     * 支付成功后修改销量
     * @param id
     * @param sales
     * @return
     */
    @PutMapping("sales")
    public ResponseEntity<Boolean> updateSales(Long id , Integer sales){
        return ResponseEntity.ok(courseService.updateCourse(id,sales));
    }
}
