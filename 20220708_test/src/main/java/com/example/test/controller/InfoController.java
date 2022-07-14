package com.example.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.test.entity.Director;

import com.example.test.entity.Info;

import com.example.test.service.IDirectorService;
import com.example.test.service.IInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Charon
 * @Date 2022/7/13
 **/
@Api
@CrossOrigin    //允许跨域注解
@RestController
public class InfoController {
    @Autowired
    private IInfoService iInfoService;

    @Autowired
    private IDirectorService directorService;

    @ApiOperation("查询所有商品数据")
    @GetMapping("goods")
    public ResponseEntity<List<Info>> goods(){
        List<Info> list = iInfoService.getList();
        return ResponseEntity.ok(list);
    }

    @ApiOperation("查询所有主管信息")
    @GetMapping("director")
    public ResponseEntity<List<Director>> getInfo(){
        return ResponseEntity.ok(directorService.list(null));
    }


    @ApiOperation("添加订单数据")
    @PostMapping("goods")
    public ResponseEntity<String> addOrders(Info info){
        info.setCode(null);
        iInfoService.save(info);
        return ResponseEntity.ok("ok");
    }

    @ApiOperation("修改订单数据")
    @PutMapping("goods")
    public ResponseEntity<String> updateInfo(Info info){
        iInfoService.updateById(info);
        return ResponseEntity.ok("ok");
    }

    @ApiOperation("删除订单数据")
    @DeleteMapping("goods/{code}")
    public ResponseEntity<String> deleteInfo(@PathVariable Long code ){
        iInfoService.removeById(code);
        return ResponseEntity.ok("ok");
    }

}
