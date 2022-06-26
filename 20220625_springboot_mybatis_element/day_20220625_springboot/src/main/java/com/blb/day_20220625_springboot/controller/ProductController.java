package com.blb.day_20220625_springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.day_20220625_springboot.entity.Product;
import com.blb.day_20220625_springboot.service.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @Author Charon
 * @Date 2022/6/25
 **/

@Api

@CrossOrigin    //允许跨域注解
@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @ApiOperation("查询所有商品数据")
    @GetMapping("ProductList")
    public ResponseEntity<List<Product>> getUserPage(){
        List<Product> list = productService.list(null);
        return ResponseEntity.ok(list);
    }

    @ApiOperation("查询分页商品数据")
    @GetMapping("productListPage/{current}/{pageSize}")
    public ResponseEntity<IPage<Product>> getLimitPage(@PathVariable Long current, @PathVariable Long pageSize){
        System.out.println(current);
        IPage<Product> page = productService.getPage(current, pageSize);
        System.out.println(page.getRecords());
        return ResponseEntity.ok(page);
    }

    @ApiOperation("新增商品数据")
    @PostMapping("product")
    public ResponseEntity<String> addProduct(Product product){

        product.setId(UUID.randomUUID().toString().replace("-","").trim());
        product.setCreateTime(LocalDateTime.now());
        System.out.println(product);
        productService.save(product);
        return ResponseEntity.ok("ok");
    }


    @ApiOperation("修改商品信息")
    @PutMapping("product")
    public ResponseEntity<String> updateProduct(@RequestBody Product product){
        product.setCreateTime(LocalDateTime.now());
        System.out.println(product);
        productService.updateById(product);
        return ResponseEntity.ok("ok");
    }


    @ApiOperation("删除商品信息")
    @DeleteMapping("product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id){
        productService.removeById(id);
        return ResponseEntity.ok("ok");


    }


}


