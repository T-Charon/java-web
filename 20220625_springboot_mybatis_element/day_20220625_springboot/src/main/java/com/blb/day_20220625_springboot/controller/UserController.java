package com.blb.day_20220625_springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.day_20220625_springboot.entity.Person;
import com.blb.day_20220625_springboot.entity.User;
import com.blb.day_20220625_springboot.service.IUserService;
import com.blb.day_20220625_springboot.utils.ResposeResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @GetMapping("users")
    public ResposeResult<List<User>> getUsers(){
        return ResposeResult.ok(userService.list(null));
    }

    @ApiOperation("查询所有用户数据")
    @GetMapping("userList")
    public ResponseEntity<List<User>> getUserPage(){
        List<User> list = userService.list(null);
        return ResponseEntity.ok(list);
    }

    @ApiOperation("查询分页用户数据")
    @GetMapping("userListPage/{current}/{pageSize}")
    public ResposeResult<IPage<User>> getLimitPage(@PathVariable Long current,@PathVariable Long pageSize){
        System.out.println(current);
        IPage<User> page = userService.getPage(current, pageSize);
        System.out.println(page.getRecords());
        return ResposeResult.ok(page);
    }

    @ApiOperation("新增用户数据")
    @PostMapping("user")
    public ResposeResult<String> addUser(User user){
        System.out.println(user);
        user.setId(UUID.randomUUID().toString().replace("-","").trim());
        user.setType(1);
        //存储加密之后的密码
        String encode = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encode);
        userService.save(user);
        return ResposeResult.ok("ok");
    }


    @ApiOperation("修改人员信息")
    @PutMapping ("user")
    public ResposeResult<String> updateUser(@RequestBody User user){

        System.out.println(user);
        //存储加密之后的密码
        String encode = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encode);
        userService.updateById(user);
        return ResposeResult.ok("ok");
    }


    @ApiOperation("删除人员信息")
    @DeleteMapping("user/{id}")
    public ResposeResult<String> deleteUser(@PathVariable String id){
        if("0".equals(id)){
            //超级管理员没有权限删除！
            return ResposeResult.ok("forbidden");
        }else {
            userService.removeById(id);
            return ResposeResult.ok("ok");
        }

    }


}
