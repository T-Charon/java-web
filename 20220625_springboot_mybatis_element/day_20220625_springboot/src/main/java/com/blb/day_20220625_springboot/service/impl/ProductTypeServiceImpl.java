package com.blb.day_20220625_springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.day_20220625_springboot.entity.ProductType;
import com.blb.day_20220625_springboot.mapper.ProductTypeMapper;
import com.blb.day_20220625_springboot.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author Charon
 * @Date 2022/6/23
 **/
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    @Autowired
    private ProductTypeMapper ProductTypeMapper;


    @Override
    public IPage<ProductType> getPage(Long current, Long size) {
        return ProductTypeMapper.selectProductTypePage(new Page<>(current,size));
    }
}
