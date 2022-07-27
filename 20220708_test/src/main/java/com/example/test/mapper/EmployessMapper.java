package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.entity.Employees;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/7/21
 **/
public interface EmployessMapper extends BaseMapper<Employees> {
    List<Employees> getList(Employees employees);
}
