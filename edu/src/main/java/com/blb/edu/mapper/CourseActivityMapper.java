package com.blb.edu.mapper;

import com.blb.edu.pojo.CourseActivity;

/**
 * @author Charon
 * @Entity com.blb.edu.pojo.CourseActivity
 */
public interface CourseActivityMapper {

    /**
     * 删除活动课程表
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);


    /**
     * 插入活动课程表
     * @param record
     * @return
     */
    int insert(CourseActivity record);

    /**
     * 选择插入活动课程表
     * @param record
     * @return
     */
    int insertSelective(CourseActivity record);

    /**
     * 根据id查询活动课程表
     * @param id
     * @return
     */
    CourseActivity selectByPrimaryKey(Long id);

    /**
     * 可选择的更新活动课程表
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(CourseActivity record);

    /**
     * 更新活动课程表
     * @param record
     * @return
     */
    int updateByPrimaryKey(CourseActivity record);

}
