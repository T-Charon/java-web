package com.blb.edu.mapper;

import com.blb.edu.pojo.CourseType;

/**
 * @Entity com.blb.edu.pojo.CourseType
 */
public interface CourseTypeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CourseType record);

    int insertSelective(CourseType record);

    CourseType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CourseType record);

    int updateByPrimaryKey(CourseType record);

}
