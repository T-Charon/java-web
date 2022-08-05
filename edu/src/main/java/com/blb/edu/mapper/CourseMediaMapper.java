package com.blb.edu.mapper;

import com.blb.edu.pojo.CourseMedia;

/**
 * @Entity com.blb.edu.pojo.CourseMedia
 */
public interface CourseMediaMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CourseMedia record);

    int insertSelective(CourseMedia record);

    CourseMedia selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CourseMedia record);

    int updateByPrimaryKey(CourseMedia record);

}
