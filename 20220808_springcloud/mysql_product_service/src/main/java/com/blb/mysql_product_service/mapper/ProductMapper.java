package com.blb.mysql_product_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.comment.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity com.blb.mysql_product_service.entity.TProduct
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    IPage<Product> getList(IPage page);

}




