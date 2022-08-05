package com.blb.edu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.edu.pojo.Course;

/**
 * @Entity com.blb.edu.pojo.Course
 */
public interface CourseMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);


    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<Course> getCoursePage(IPage<Course> page);

}
