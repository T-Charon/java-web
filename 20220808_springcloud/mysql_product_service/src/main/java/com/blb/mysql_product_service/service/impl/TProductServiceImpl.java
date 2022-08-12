package com.blb.mysql_product_service.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.comment.entity.Product;
import com.blb.mysql_product_service.mapper.ProductMapper;
import com.blb.mysql_product_service.service.TProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class TProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements TProductService{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<Product> getList(int current, int size) {

        return productMapper.getList(new Page(current,size));
    }
}




