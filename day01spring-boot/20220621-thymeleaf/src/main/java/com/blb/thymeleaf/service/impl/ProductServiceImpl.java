package com.blb.thymeleaf.service.impl;


import com.blb.thymeleaf.entity.Product;
import com.blb.thymeleaf.mapper.ProductMapper;
import com.blb.thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/20
 **/

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> selectAll() {
        return productMapper.selectAll();
    }

    @Override
    public List<Product> limitAll(int page, int size) {
        return productMapper.limitAll(page,size);
    }

    @Override
    public Product getById(String id) {
        return productMapper.getById(id);
    }

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public void deleteProduct(String id) {
        productMapper.deleteProduct(id);
    }
}
