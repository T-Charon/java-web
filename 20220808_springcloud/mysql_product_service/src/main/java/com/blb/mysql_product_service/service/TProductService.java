package com.blb.mysql_product_service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blb.comment.entity.Product;

/**
 *
 */
public interface TProductService extends IService<Product> {
    /**
     *  分页查询
     * @param current
     * @param size
     * @return
     */
    IPage<Product> getList(int current, int size);

}
