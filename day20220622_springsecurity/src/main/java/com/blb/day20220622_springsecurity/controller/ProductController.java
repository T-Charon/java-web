package com.blb.day20220622_springsecurity.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.day20220622_springsecurity.entity.Product;
import com.blb.day20220622_springsecurity.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @Author Charon
 * @Date 2022/6/22
 **/

@Controller
public class ProductController {

    @Autowired
    private IProductService productService;
    @GetMapping("/index")
    public String getPage(@RequestParam(required = false,defaultValue = "1") Long current,
                        Model model){
        System.out.println(current);
        IPage<Product> page = productService.getPage(current, 5L);
        System.out.println(page);
        model.addAttribute("page",page);
        return "list";
    }

    @GetMapping("/addpage")
    public String addPage(){
        return "add";
    }


    @ResponseBody
    @PostMapping ("/add")
    public String add(Product product){
        System.out.println("add");
        product.setCreateTime(LocalDateTime.now());
        product.setId(UUID.randomUUID().toString().replace("-","").trim());
        System.out.println(product);
        productService.addProduct(product);
        return "ok";
    }


    @ResponseBody
    @DeleteMapping ("/delete/{id}")
    public boolean delete( String id){
        System.out.println(id);
        return productService.removeById(id);
    }


    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable String id,Model model){
        System.out.println(id);
        Product product = productService.getById(id);
        System.out.println("要更新商品为"+product);
        model.addAttribute("products",product);
        return "update";
    }


    @ResponseBody
    @PutMapping ("/updateproduct")
    public boolean update(Product product) {
        System.out.println("更新");
        System.out.println("更新后商品为"+product);
        return productService.updateById(product);
    }




}
