package com.blb.zy_community.controller;

import com.blb.zy_community.entity.SysMenu;
import com.blb.zy_community.entity.SysUser;
import com.blb.zy_community.service.IUserService;
import com.blb.zy_community.utils.ResposeResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/7/2
 **/

@Api
@CrossOrigin
@RestController
public class MenuController {

    @Autowired
    private IUserService userService;

    /**
     * 获取用户菜单
     * @param username
     * @return
     */
    @ApiOperation("查询用户菜单")
    @GetMapping("menus/{username}")
    public ResposeResult<List<SysMenu>> getMenuByUsername(@PathVariable String username){
        System.out.println(username);
        return ResposeResult.ok(userService.selectMenuByUsername(username));
    }
}
