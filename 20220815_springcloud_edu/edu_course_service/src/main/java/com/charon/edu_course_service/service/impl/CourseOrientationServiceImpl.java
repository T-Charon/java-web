package com.charon.edu_course_service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.charon.comment.entity.CourseOrientation;
import com.charon.edu_course_service.mapper.CourseOrientationMapper;
import com.charon.edu_course_service.service.CourseOrientationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Charon
 */
@Service
public class CourseOrientationServiceImpl extends ServiceImpl<CourseOrientationMapper, CourseOrientation>
    implements CourseOrientationService{

    @Autowired
    CourseOrientationMapper courseOrientationMapper;
    @Override
    public List<CourseOrientation> getListCourseOrientation() {
        List<CourseOrientation> list = courseOrientationMapper.selectList(new QueryWrapper<CourseOrientation>().lambda()
                .eq(CourseOrientation::getParentId, 0));
        return list;
    }

    @Override
    public List<CourseOrientation> getListCourseOrientationChildren(Integer id) {
        List<CourseOrientation> list = courseOrientationMapper.selectList(new QueryWrapper<CourseOrientation>().lambda()
                .eq(CourseOrientation::getParentId, id));
        return list;
    }
}




