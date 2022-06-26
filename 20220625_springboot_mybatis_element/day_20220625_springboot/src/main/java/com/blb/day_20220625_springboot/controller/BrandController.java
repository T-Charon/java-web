package com.blb.day_20220625_springboot.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.day_20220625_springboot.entity.Brand;
import com.blb.day_20220625_springboot.entity.ProductType;
import com.blb.day_20220625_springboot.entity.User;
import com.blb.day_20220625_springboot.service.IBrandService;
import com.blb.day_20220625_springboot.service.IProductTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class BrandController {
    @Autowired
    private IBrandService brandService;

    @Autowired
    private IProductTypeService productTypeService;

    @ApiOperation("查询所有品牌类型数据")
    @GetMapping("productTypeName")
    public ResponseEntity<List<ProductType>> getProductType(){
        List<ProductType> list = productTypeService.list(null);

        return ResponseEntity.ok(list);
    }


    @ApiOperation("查询所有品牌数据")
    @GetMapping("brandList")
    public ResponseEntity<List<Brand>> getBrandPage(){
        List<Brand> list = brandService.list(null);
        return ResponseEntity.ok(list);
    }

    @ApiOperation("查询分页品牌数据")
    @GetMapping("brandListPage/{current}/{pageSize}")
    public ResponseEntity<IPage<Brand>> getLimitPage(@PathVariable Long current, @PathVariable Long pageSize){
        System.out.println(current);
        IPage<Brand> page = brandService.getPage(current, pageSize);
        System.out.println(page.getRecords());
        return ResponseEntity.ok(page);
    }

    @ApiOperation("新增品牌数据")
    @PostMapping("brand")
    public ResponseEntity<String> addBrand(Brand brand){
        System.out.println(brand);
        brand.setId(UUID.randomUUID().toString().replace("-","").trim());
        brandService.save(brand);
        return ResponseEntity.ok("ok");
    }


    @ApiOperation("修改品牌信息")
    @PutMapping("brand")
    public ResponseEntity<String> updateBrand(@RequestBody Brand brand){
        System.out.println(brand);
        brandService.updateById(brand);
        return ResponseEntity.ok("ok");
    }


    @ApiOperation("删除品牌信息")
    @DeleteMapping("brand/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable String id){

            brandService.removeById(id);
            return ResponseEntity.ok("ok");


    }


}


