package com.blb.mysql_product_service.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.comment.entity.Product;
import com.blb.mysql_product_service.service.TProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Charon
 * @Date 2022/8/10
 **/

@RefreshScope
@RestController
public class ProductController {

    @Autowired
    private TProductService productService;

    @GetMapping("/productlist/{current}/{size}")
    public ResponseEntity<IPage<Product>> getList(@PathVariable int current, @PathVariable int size){
        return ResponseEntity.ok( productService.getList(current,size));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getById(id));
    }
    @PostMapping("/product")
    public ResponseEntity<String> addProduct(Product product){
        productService.save(product);
        return ResponseEntity.ok("ok");
    }

    @PutMapping("/product")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        productService.updateById(product);
        return ResponseEntity.ok("ok");
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.removeById(id);
        return ResponseEntity.ok("ok");
    }


}
