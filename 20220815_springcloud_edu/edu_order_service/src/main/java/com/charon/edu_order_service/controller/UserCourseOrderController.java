package com.charon.edu_order_service.controller;

import com.charon.comment.entity.UserCourseOrder;
import com.charon.edu_order_service.service.UserCourseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @Author Charon
 * @Date 2022/8/31
 **/
@RestController
@RequestMapping("order")
public class UserCourseOrderController {
    @Autowired
    private UserCourseOrderService userCourseOrderService;

    @PostMapping("add")
    public ResponseEntity<Boolean> savaOrder(@RequestBody UserCourseOrder userCourseOrder){
        userCourseOrder.setCreateTime(LocalDateTime.now());
        userCourseOrder.setUpdateTime(LocalDateTime.now());
        return ResponseEntity.ok(userCourseOrderService.save(userCourseOrder));
    };

    @PutMapping("update")
    public ResponseEntity<Boolean> updateOrder(Long id,Byte status){
        return  ResponseEntity.ok(userCourseOrderService.updateOrder(id, status));
    }

    @GetMapping("getCourse/{tradeNo}")
    public ResponseEntity<UserCourseOrder>getById(@PathVariable Long tradeNo){
        return ResponseEntity.ok(userCourseOrderService.getById(tradeNo));
    }




}
