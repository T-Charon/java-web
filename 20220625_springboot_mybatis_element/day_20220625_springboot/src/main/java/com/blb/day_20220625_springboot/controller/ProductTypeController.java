package com.blb.day_20220625_springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.day_20220625_springboot.entity.ProductType;
import com.blb.day_20220625_springboot.service.IProductTypeService;
import com.blb.day_20220625_springboot.utils.ResposeResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author Charon
 * @Date 2022/6/25
 **/


@Api
@CrossOrigin    //允许跨域注解
@RestController
public class ProductTypeController {
    @Autowired
    private IProductTypeService productTypeService;

    @ApiOperation("查询所有品牌类型数据")
    @GetMapping("productTypeList")
    public ResposeResult<List<ProductType>> getProductTypePage(){
        List<ProductType> list = productTypeService.list(null);
        return ResposeResult.ok(list);
    }

    @ApiOperation("查询分页品牌类型数据")
    @GetMapping("productTypeListPage/{current}/{pageSize}")
    public ResposeResult<IPage<ProductType>> getLimitPage(@PathVariable Long current, @PathVariable Long pageSize){
        System.out.println(current);
        IPage<ProductType> page = productTypeService.getPage(current, pageSize);
        System.out.println(page.getRecords());
        return ResposeResult.ok(page);
    }

    @ApiOperation("新增品牌类型数据")
    @PostMapping("productType")
    public ResposeResult<String> addProductType(ProductType productType){
        System.out.println(productType);
        productType.setId(UUID.randomUUID().toString().replace("-","").trim());
        productTypeService.save(productType);
        return ResposeResult.ok("ok");
    }


    @ApiOperation("修改品牌类型信息")
    @PutMapping("productType")
    public ResposeResult<String> updateProductType(@RequestBody ProductType productType){
        System.out.println(productType);
        productTypeService.updateById(productType);
        return ResposeResult.ok("ok");
    }


    @ApiOperation("删除品牌类型信息")
    @DeleteMapping("productType/{id}")
    public ResposeResult<String> deleteProductType(@PathVariable String id){

            productTypeService.removeById(id);
            return ResposeResult.ok("ok");


    }


}


