package com.blb.day20220622_springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.day20220622_springsecurity.entity.Product;

/**
 * @Author Charon
 * @Date 2022/6/22
 **/

/**
 * 商品映射接口
 */
public interface ProductMapper extends BaseMapper<Product> {
    /**
     * 分页查询数据
     * @param page
     * @return
     */
    IPage<Product> selectProductPage(IPage<Product> page);

    /**
     * 添加商品
     * @param product
     */
    void addProduct(Product product);
}
