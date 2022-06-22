package com.blb.thymeleaf.service;

import com.blb.thymeleaf.entity.Product;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/21
 **/
public interface IProductService {
    /**
     * 查询所有商品
     * @return
     */
    List<Product> selectAll();

    /**
     * 分页查询所有商品
     * @param page 当前页数
     * @param size 每页条数
     * @return
     */
    List<Product> limitAll(int page,int size);

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    Product getById(String id);

    /**
     * 添加商品
     * @param product
     */
    void addProduct(Product product);

    /**
     * 更新商品信息
     * @param product
     */
    void updateProduct(Product product);

    /**
     * 删除商品
     * @param id
     */
    void deleteProduct(String id);
}
