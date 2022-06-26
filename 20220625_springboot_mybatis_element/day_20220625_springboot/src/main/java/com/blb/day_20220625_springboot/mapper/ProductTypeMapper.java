package com.blb.day_20220625_springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.day_20220625_springboot.entity.ProductType;

/**
 * @Author Charon
 * @Date 2022/6/25
 **/
public interface ProductTypeMapper extends BaseMapper<ProductType> {

    IPage<ProductType> selectProductTypePage(IPage<ProductType> page);
}
