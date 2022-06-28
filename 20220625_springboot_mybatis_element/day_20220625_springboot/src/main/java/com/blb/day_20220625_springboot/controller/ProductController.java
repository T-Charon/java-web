package com.blb.day_20220625_springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.day_20220625_springboot.entity.Brand;
import com.blb.day_20220625_springboot.entity.Product;
import com.blb.day_20220625_springboot.service.IBrandService;
import com.blb.day_20220625_springboot.service.IProductService;
import com.blb.day_20220625_springboot.utils.ResposeResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private IBrandService brandService;

    @ApiOperation("查询所有商品数据")
    @GetMapping("ProductList")
    public ResposeResult<List<Product>> getUserPage(){
        List<Product> list = productService.list(null);
        return ResposeResult.ok(list);
    }

    @ApiOperation("查询分页商品数据")
    @GetMapping("productListPage/{current}/{pageSize}")
    public ResposeResult<IPage<Product>> getLimitPage(@PathVariable Long current, @PathVariable Long pageSize){
        System.out.println(current);
        IPage<Product> page = productService.getPage(current, pageSize);
        System.out.println(page.getRecords());
        return ResposeResult.ok(page);
    }

    @ApiOperation("新增商品数据")
    @PostMapping("product")
    public ResposeResult<String> addProduct(Product product){

        product.setId(UUID.randomUUID().toString().replace("-","").trim());
        product.setCreateTime(LocalDateTime.now());
        Brand brand = brandService.getBrandByName(product.getProductBrand());
        product.setProductBrand(brand.getId());
        product.setProductType(brand.getBrandType());
        System.out.println(product);
        productService.save(product);
        return ResposeResult.ok("ok");
    }


    @ApiOperation("修改商品信息")
    @PutMapping("product")
    public ResposeResult<String> updateProduct(@RequestBody Product product){
        product.setCreateTime(LocalDateTime.now());
        Brand brand = brandService.getBrandByName(product.getProductBrand());
        product.setProductBrand(brand.getId());
        product.setProductType(brand.getBrandType());
        System.out.println(product);
        productService.updateById(product);
        return ResposeResult.ok("ok");
    }


    @ApiOperation("删除商品信息")
    @DeleteMapping("product/{id}")
    public ResposeResult<String> deleteProduct(@PathVariable String id){
        productService.removeById(id);
        return ResposeResult.ok("ok");


    }


}


