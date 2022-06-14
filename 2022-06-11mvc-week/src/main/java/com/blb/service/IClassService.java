package com.blb.service;

import com.blb.entity.Class;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/11
 **/


public interface IClassService {

    /**
     * 查询班级信息（包含总人数）
     * @return
     */
    List<Class> list();

    /**
     * 根据name查询班级信息
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
