package com.blb.springboot.service;


import com.blb.springboot.entity.LLogistic;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/28
 **/
public interface ILogisticsService {
    List<LLogistic> selectAll();
}
