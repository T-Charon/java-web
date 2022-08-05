package com.blb.edu.mapper;


import com.blb.edu.pojo.CourseLesson;

/**
 * @author Charon
 * @Entity com.blb.edu.pojo.CourseLesson
 */
public interface CourseLessonMapper {

    /**
     * 删除课程节内容
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    int insert(CourseLesson record);

    int insertSelective(CourseLesson record);

    CourseLesson selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CourseLesson record);

    int updateByPrimaryKey(CourseLesson record);

}
