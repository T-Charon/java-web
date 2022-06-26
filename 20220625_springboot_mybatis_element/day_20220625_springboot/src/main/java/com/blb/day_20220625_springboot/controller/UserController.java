package com.blb.day_20220625_springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.day_20220625_springboot.entity.Person;
import com.blb.day_20220625_springboot.entity.User;
import com.blb.day_20220625_springboot.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @Author Charon
 * @Date 2022/6/25
 **/

@Api
@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation("查询所有用户数据")
    @GetMapping("userList")
    public ResponseEntity<List<User>> getUserPage(){
        List<User> list = userService.list(null);
        return ResponseEntity.ok(list);
    }

    @ApiOperation("查询分页用户数据")
    @GetMapping("userListPage/{current}/{pageSize}")
    public ResponseEntity<IPage<User>> getLimitPage(@PathVariable Long current,@PathVariable Long pageSize){
        System.out.println(current);
        IPage<User> page = userService.getPage(current, pageSize);
        System.out.println(page.getRecords());
        return ResponseEntity.ok(page);
    }

    @ApiOperation("新增用户数据")
    @PostMapping("user")
    public ResponseEntity<String> addUser(User user){
        System.out.println(user);
        user.setId(UUID.randomUUID().toString().replace("-","").trim());
        user.setType(1);
        userService.save(user);
        return ResponseEntity.ok("ok");
    }


    @ApiOperation("修改人员信息")
    @PutMapping ("user")
    public ResponseEntity<String> updateUser(@RequestBody User user){

        System.out.println(user);
        userService.updateById(user);
        return ResponseEntity.ok("ok");
    }


    @ApiOperation("删除人员信息")
    @DeleteMapping("user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        if("0".equals(id)){
            //超级管理员没有权限删除！
            return ResponseEntity.ok("forbidden");
        }else {
            userService.removeById(id);
            return ResponseEntity.ok("ok");
        }

    }


}
