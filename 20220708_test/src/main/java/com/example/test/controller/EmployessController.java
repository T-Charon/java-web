package com.example.test.controller;

import com.example.test.entity.Dept;
import com.example.test.entity.Employees;
import com.example.test.service.IDeptService;
import com.example.test.service.IEmployessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/7/13
 **/
@Api
@CrossOrigin    //允许跨域注解
@RestController
public class EmployessController {
    @Autowired
    private IEmployessService iEmployessService;


    @Autowired()
    private IDeptService deptService;

    @ApiOperation("查询所有员工信息")
    @GetMapping("employess")
    public ResponseEntity<List<Employees>> employess(Employees employees){
        List<Employees> list = iEmployessService.getList(employees);
        return ResponseEntity.ok(list);
    }

    @ApiOperation("查询所有部门信息")
    @GetMapping("dept")
    public ResponseEntity<List<Dept>> getEmployess(){
        return ResponseEntity.ok(deptService.list(null));
    }


    @ApiOperation("添加员工信息")
    @PostMapping("employess")
    public ResponseEntity<String> addEmployess(Employees employees){
        employees.setId(null);
        iEmployessService.save(employees);
        return ResponseEntity.ok("ok");
    }

    @ApiOperation("修改员工数据")
    @PutMapping("employess")
    public ResponseEntity<String> updateEmployess(Employees employees){
        iEmployessService.updateById(employees);
        return ResponseEntity.ok("ok");
    }

    @ApiOperation("删除员工数据")
    @DeleteMapping("employess/{id}")
    public ResponseEntity<String> deleteEmployess(@PathVariable Long id ){
        iEmployessService.removeById(id);
        return ResponseEntity.ok("ok");
    }

}
