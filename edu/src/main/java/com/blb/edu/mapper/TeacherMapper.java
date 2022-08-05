package com.blb.edu.mapper;

import com.blb.edu.pojo.Teacher;

/**
 * @Entity com.blb.edu.pojo.Teacher
 */
public interface TeacherMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

}
