package com.charon.edu_course_service.controlller;

import com.charon.edu_course_service.service.CourseActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Charon
 * @Date 2022/8/31
 **/
@RestController
@RequestMapping("courseActivity")
public class CourseActivityController {
    @Autowired
    private CourseActivityService courseActivityService;

    /**
     * 修改库存
     * @return
     */
    @PutMapping("updateStock")
    public ResponseEntity<Boolean>changeStock(Long activityId,long num){
        return ResponseEntity.ok(courseActivityService.changeStock(activityId, num));
    }
}
