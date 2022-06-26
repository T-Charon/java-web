package com.blb.day_20220625_springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blb.day_20220625_springboot.entity.ProductType;

/**
 * @Author Charon
 * @Date 2022/6/25
 **/
public interface IProductTypeService extends IService<ProductType> {
    /**
     * 获取分页数据
     * @param current
     * @param size
     * @return
     */
    IPage<ProductType> getPage(Long current, Long size);
}
