package com.blb.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.springboot.entity.LLogistic;

import java.util.List;

/**
 * @Author Charon
 * @Date 2022/6/28
 **/
public interface LogisticsMapper extends BaseMapper<LLogistic> {

    List<LLogistic> selectAll();
}
