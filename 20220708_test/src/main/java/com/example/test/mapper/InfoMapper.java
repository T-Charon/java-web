package com.example.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.entity.Info;


import java.util.List;

/**
 * @Author Charon
 * @Date 2022/7/13
 **/
public interface InfoMapper extends BaseMapper<Info> {
    List<Info> getList();
}
