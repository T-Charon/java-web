//package com.blb.springboot.controller;
//
//import com.blb.springboot.entity.Product;
//import com.blb.springboot.service.IProductService;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
///**
// * @Author Charon
// * @Date 2022/6/20
// **/
//
//@RestController
//public class ProductController {
//
//    @Autowired
//    IProductService productService;
//
//    @GetMapping("seleteall")
//    public List<Product> selectAll(){
//        return productService.selectAll();
//    }
//
//    @GetMapping("limitall/{page}/{size}")
//    public List<Product> limitAll(@PathVariable int page,@PathVariable int size){
//        System.out.println(page);
//        return productService.limitAll(page,size);
//    }
//
//    @GetMapping("getbyid")
//    public Product getById(String id){
//        return productService.getById(id);
//    }
//
//    @PostMapping("product")
//    public void add(){
//        LocalDateTime now = LocalDateTime.now();
//        Product product = new Product("222","222","333"
//                ,22D,"555","888",now,"0");
//        productService.addProduct(product);
//    }
//
//    @PutMapping("product")
//    public void update(Product product){
//        productService.updateProduct(product);
//    }
//
//    @DeleteMapping("product/{id}")
//    public void delete(@PathVariable int id){
//        System.out.println(id);
//        productService.deleteProduct(String.valueOf(id));
//    }
//
//}
