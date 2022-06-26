package com.blb.day_20220625_springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.day_20220625_springboot.entity.Brand;
import com.blb.day_20220625_springboot.entity.Product;

/**
 * @Author Charon
 * @Date 2022/6/25
 **/
public interface ProductMapper extends BaseMapper<Product> {

    IPage<Product> selectProductPage(IPage<Product> page);
}
