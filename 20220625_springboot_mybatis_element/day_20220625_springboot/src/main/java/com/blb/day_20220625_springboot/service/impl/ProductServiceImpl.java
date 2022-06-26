package com.blb.day_20220625_springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.day_20220625_springboot.entity.Product;
import com.blb.day_20220625_springboot.mapper.ProductMapper;
import com.blb.day_20220625_springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author Charon
 * @Date 2022/6/23
 **/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ProductMapper ProductMapper;


    @Override
    public IPage<Product> getPage(Long current, Long size) {
        return ProductMapper.selectProductPage(new Page<>(current,size));
    }
}
