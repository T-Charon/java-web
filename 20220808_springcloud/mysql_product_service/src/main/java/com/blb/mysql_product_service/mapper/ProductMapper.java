package com.blb.mysql_product_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.comment.entity.Product;

/**
 * @Entity com.blb.mysql_product_service.entity.TProduct
 */
public interface ProductMapper extends BaseMapper<Product> {

    IPage<Product> getList(IPage page);

}




