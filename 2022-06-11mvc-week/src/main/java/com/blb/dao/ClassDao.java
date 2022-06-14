package com.blb.dao;

import com.blb.entity.Class;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/11
 **/


public interface ClassDao {
    /**
     * 查询班级信息（包含总人数）
     * @return
     */
    List<Class> list();

    /**
     * 根据id查询班级信息
     * @param name
     * @return
     */
    List<Class> getByName(String name);

    /**
     * 修改班级信息
     * @param classInfo
     */
    void updateClass(Class classInfo);

    /**
     * 删除班级信息
     * @param id
     */
    void deleteClass(int id);

}
