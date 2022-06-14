package com.blb.service.impl;

import com.blb.dao.StudentDao;
import com.blb.entity.Student;
import com.blb.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/11
 **/

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> list(int  id) {

        return  studentDao.list(id);
    }

    @Override
    public List<Student> getById(int id) {
        return studentDao.getById(id);
    }

    @Override
    public List<Student> getByCId(int cId) {
        return studentDao.getByCId(cId);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }


    @Override
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }
}
