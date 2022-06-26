package com.blb.day_20220625_springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.day_20220625_springboot.entity.Person;


/**
 * @Author Charon
 * @Date 2022/6/23
 **/
public interface PersonMapper extends BaseMapper<Person> {


    /**
     * 分页查询数据
     * @param page
     * @return
     */
    IPage<Person> selectPersonPage(IPage<Person> page);
}
