package com.charon.edu_search_service.com.charon.feign;

import com.charon.comment.entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/8/22
 **/
@FeignClient("course-service")
public interface CourseFeign {
    /**
     * 获取所有课程信息
     * @return
     */
    @GetMapping("/course/getAllCourse")
    List<Course> getAllCourse();
}
