package com.blb.product_service.controller;

import com.blb.product_service.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Author Charon
 * @Date 2022/8/8
 **/
@RestController
public class ProductServiceController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        Product product = new Product(id, "测试商品"+port, new BigDecimal(99.999));
        return ResponseEntity.ok(product);
    }
}
