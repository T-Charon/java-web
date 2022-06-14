package com.blb.dao.impl;

import com.blb.dao.StudentDao;
import com.blb.entity.Class;
import com.blb.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/11
 **/

@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Student> list(int  id) {
        List<Student> studentList = jdbcTemplate.query("select s.*  from t_student s\n" +
                "left join t_class c\n" +
                "on s.class_id = c.id\n" +
                "where c.id = ? ", new BeanPropertyRowMapper<>(Student.class),id);
        return studentList;
    }

    @Override
    public List<Student> getById(int id) {
        List<Student> students = jdbcTemplate.query("select * from t_student where id = ?", new BeanPropertyRowMapper<>(Student.class), id);
        return students;
    }

    @Override
    public List<Student> getByCId(int cId) {
        List<Student> cIdInfo = jdbcTemplate.query("select * from t_student where class_id = ?", new BeanPropertyRowMapper<>(Student.class), cId);
        return cIdInfo;
    }

    @Override
    public void addStudent(Student student) {
        jdbcTemplate.update("insert into t_student (name,age,sex,img,class_id) values (?,?,?,?,?)"
                ,student.getName(),student.getAge(),student.getSex(),student.getImg(),student.getClassId());
    }

    @Override
    public void updateStudent(Student student) {
        jdbcTemplate.update("update t_student set name=?,age=?,sex=?,img=?  where id=?"
                ,student.getName(),student.getAge(),student.getSex(),student.getImg(),student.getId());
    }


    @Override
    public void deleteStudent(int id) {
        jdbcTemplate.update("delete from t_student where id= ?",id);
    }
}
