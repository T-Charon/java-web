package com.blb.dao;

import com.blb.entity.Class;
import com.blb.entity.Student;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/11
 **/
public interface StudentDao {

    /**
     * 查询班级的所有学生信息
     * @return
     */
    List<Student> list(int  id);

    /**
     * 根据学生id查询学生信息
     * @param id
     * @return
     */
    List<Student> getById(int id);

    /**
     * 根据班级Id查询学生信息
     * @param cId
     * @return
     */
    List<Student> getByCId(int cId);


    /**
     * 添加学生信息
     * @param student
     */
    void addStudent(Student student);

    /**
     * 修改学生信息
     * @param student
     */
    void updateStudent(Student student);


    /**
     * 删除学生信息
     * @param id
     */
    void deleteStudent(int id);
}
