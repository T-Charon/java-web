package com.blb.edu.mapper;

import com.blb.edu.pojo.CourseOrientation;

/**
 * @Entity com.blb.edu.pojo.CourseOrientation
 */
public interface CourseOrientationMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CourseOrientation record);

    int insertSelective(CourseOrientation record);

    CourseOrientation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CourseOrientation record);

    int updateByPrimaryKey(CourseOrientation record);

}
