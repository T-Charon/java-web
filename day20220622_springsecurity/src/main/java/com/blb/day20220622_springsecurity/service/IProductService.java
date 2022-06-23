package com.blb.day20220622_springsecurity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blb.day20220622_springsecurity.entity.Product;

/**
 * @Author Charon
 * @Date 2022/6/22
 **/

/**
 * 商品业务逻辑接口
 */
public interface IProductService extends IService<Product> {

    IPage<Product> getPage(Long current,Long size);

    /**
     * 添加商品
     * @param product
     */
    void addProduct(Product product);
}
