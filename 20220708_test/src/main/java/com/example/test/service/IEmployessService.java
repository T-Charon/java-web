package com.example.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.test.entity.Employees;
import com.example.test.entity.Info;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/7/13
 **/

public interface IEmployessService extends IService<Employees> {

    List<Employees> getList(Employees employees);
}
