package com.blb.springboot.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blb.springboot.entity.Person;

/**
 * @Author Charon
 * @Date 2022/6/23
 **/


public interface IPersonService extends IService<Person> {

    /**
     *
     * @param current 当前页数
     * @param size 每页条数
     * @return
     */
    IPage<Person> getPage(Long current,Long size);
}
