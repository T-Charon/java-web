package com.blb.day_20220625_springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blb.day_20220625_springboot.entity.Brand;
import com.blb.day_20220625_springboot.entity.User;

/**
 * @Author Charon
 * @Date 2022/6/25
 **/
public interface IBrandService extends IService<Brand> {
    /**
     * 获取分页数据
     * @param current
     * @param size
     * @return
     */
    IPage<Brand> getPage(Long current, Long size);

    Brand getBrandByName(String brandName);
}
