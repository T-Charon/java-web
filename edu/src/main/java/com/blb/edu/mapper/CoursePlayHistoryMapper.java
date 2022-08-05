package com.blb.edu.mapper;

import com.blb.edu.pojo.CoursePlayHistory;

/**
 * @Entity com.blb.edu.pojo.CoursePlayHistory
 */
public interface CoursePlayHistoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(CoursePlayHistory record);

    int insertSelective(CoursePlayHistory record);

    CoursePlayHistory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CoursePlayHistory record);

    int updateByPrimaryKey(CoursePlayHistory record);

}
