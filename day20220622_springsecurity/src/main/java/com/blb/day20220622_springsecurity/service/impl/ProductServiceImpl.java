package com.blb.day20220622_springsecurity.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.day20220622_springsecurity.entity.Product;
import com.blb.day20220622_springsecurity.mapper.ProductMapper;
import com.blb.day20220622_springsecurity.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Charon
 * @Date 2022/6/22
 **/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper,Product> implements IProductService{

    @Autowired
    private ProductMapper productMapper;
    @Override
    public IPage<Product> getPage(Long current, Long size) {
        return productMapper.selectProductPage(new Page(current,size));
    }

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }
}
