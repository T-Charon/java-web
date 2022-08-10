package com.blb.order_service.controller;

import com.blb.order_service.entity.Order;
import com.blb.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Charon
 * @Date 2022/8/8
 **/
@RestController
public class OrderServiceController {
    @Autowired
    private OrderService orderService;

    @GetMapping("order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id){
        Order order = orderService.getOrderById(id);
        return  ResponseEntity.ok(order);
    }
}
