package com.example.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.test.entity.Employees;

import com.example.test.mapper.EmployessMapper;
import com.example.test.service.IEmployessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/7/13
 **/
@Service
public class EmployessServiceImpl extends ServiceImpl<EmployessMapper, Employees> implements IEmployessService {

    @Autowired
    private EmployessMapper employessMapper;


    @Override
    public List<Employees> getList(Employees employees) {
        return employessMapper.getList(employees);
    }
}
