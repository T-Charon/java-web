package com.blb.service.impl;

import com.blb.dao.ClassDao;
import com.blb.entity.Class;
import com.blb.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/11
 **/

@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    private ClassDao classDao;

    @Override
    public List<Class> list() {
        return classDao.list();
    }


    @Override
    public List<Class> getByName(String name) {
        return classDao.getByName(name);
    }

    @Override
    public void updateClass(Class classInfo) {

        classDao.updateClass(classInfo);
    }

    @Override
    public void deleteClass(int id) {
        classDao.deleteClass(id);
    }
}
