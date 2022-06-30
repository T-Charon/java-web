package com.blb.springboot.service.impl;


import com.blb.springboot.entity.LLogistic;
import com.blb.springboot.mapper.LogisticsMapper;
import com.blb.springboot.service.ILogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/28
 **/

@Service
public class LogisticsServiceImpl implements ILogisticsService {

    @Autowired
    private LogisticsMapper logisticsMapper;


    @Override
    public List<LLogistic> selectAll() {
        return logisticsMapper.selectAll();
    }
}
