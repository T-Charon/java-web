package com.charon.edu_course_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.charon.comment.entity.CourseOrientation;

import java.util.List;

/**
 *
 * @author Charon
 */
public interface CourseOrientationService extends IService<CourseOrientation> {

    /**
     * 查询所有一级方向课程
     * @return
     */
   List<CourseOrientation> getListCourseOrientation();

    /**
     * 按上级方向id查询子级课程方向
     * @param parentId
     * @return
     */
   List<CourseOrientation> getListCourseOrientationChildren( Integer parentId);


}
