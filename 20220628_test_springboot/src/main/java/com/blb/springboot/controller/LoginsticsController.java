package com.blb.springboot.controller;

import com.blb.springboot.entity.LLogistic;
import com.blb.springboot.service.ILogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/28
 **/

@CrossOrigin
@RestController
public class LoginsticsController {
    @Autowired
    private ILogisticsService iLogisticsService;



    @GetMapping("list")
    public ResponseEntity<List<LLogistic>> list(){
        List<LLogistic> lLogistics = iLogisticsService.selectAll();
        return ResponseEntity.ok(lLogistics);
    }
}
