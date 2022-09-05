package com.charon.edu_canal_service.feign;

import com.charon.comment.entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Charon
 * @Date 2022/8/27
 **/
@FeignClient("course-service")
public interface CourseFeignClient {
    /**
     * 调用课程服务（根据id查询所有课程）
     * @param id
     * @return
     */
    @GetMapping("/course/getCourseInfoById/{id}")
    Course getCourseInfoById(@PathVariable Long id);
}
