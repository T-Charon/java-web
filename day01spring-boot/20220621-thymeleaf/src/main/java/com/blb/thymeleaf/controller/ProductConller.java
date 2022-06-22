package com.blb.thymeleaf.controller;

import com.blb.thymeleaf.entity.Product;
import com.blb.thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @Author Charon
 * @Date 2022/6/21
 **/

@Controller
public class ProductConller {

    @Autowired
    private IProductService productService;

    @GetMapping("index")
    public String list(Model model){
        List<Product> products = productService.selectAll();
        model.addAttribute("list",products);
        return "list";
    }


    @GetMapping("addpage")
    public String addPage(){
        return "add";
    }


    @ResponseBody
    @PostMapping("add")
    public String add(Product product){
        product.setCreateTime(LocalDateTime.now());
        product.setId(UUID.randomUUID().toString().replace("-","").trim());
        System.out.println(product);
        productService.addProduct(product);
        return "ok";
    }


    @ResponseBody
    @DeleteMapping ("delete/{id}")
    public String delete( String id){
        System.out.println(id);
        productService.deleteProduct(id);
        return "ok";
    }


    @GetMapping("update/{id}")
    public String updatePage(@PathVariable String id,Model model){
        System.out.println(id);
        Product product = productService.getById(id);
        System.out.println("要更新商品为"+product);
        model.addAttribute("products",product);
        return "update";
    }


    @ResponseBody
    @PutMapping("updateproduct")
    public String update(Product product) {
        System.out.println("更新后商品为"+product);
        productService.updateProduct(product);
        return "ok";
    }


}
