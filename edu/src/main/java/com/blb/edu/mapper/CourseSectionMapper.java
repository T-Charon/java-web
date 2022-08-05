package com.blb.edu.mapper;

import com.blb.edu.pojo.CourseSection;

/**
 * @Entity com.blb.edu.pojo.CourseSection
 */
public interface CourseSectionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CourseSection record);

    int insertSelective(CourseSection record);

    CourseSection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CourseSection record);

    int updateByPrimaryKey(CourseSection record);

}
