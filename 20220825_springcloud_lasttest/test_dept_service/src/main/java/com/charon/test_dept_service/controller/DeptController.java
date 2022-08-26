package com.charon.test_dept_service.controller;

import com.charon.test_dept_service.entity.Dept;
import com.charon.test_dept_service.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/8/25
 **/

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 获取所有部门信息
     * @return
     */
    @GetMapping("getAllDept")
    List<Dept> getAllDept(){
        List<Dept> list = deptService.list();
        return list;
    }

    /**
     * 根据id查询部门
     * @return
     */
    @GetMapping("getDeptById/{id}")
    Dept getDeptById(@PathVariable int id){
        Dept dept = deptService.getById(id);
        return dept;
    }

}
