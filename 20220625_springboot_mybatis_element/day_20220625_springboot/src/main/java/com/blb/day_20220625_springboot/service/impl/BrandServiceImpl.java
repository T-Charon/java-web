package com.blb.day_20220625_springboot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blb.day_20220625_springboot.entity.Brand;
import com.blb.day_20220625_springboot.mapper.BrandMapper;
import com.blb.day_20220625_springboot.service.IBrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author Charon
 * @Date 2022/6/23
 **/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;


    @Override
    public IPage<Brand> getPage(Long current, Long size) {
        return brandMapper.selectBrandPage(new Page<>(current,size));
    }
}
