package com.blb.day_20220625_springboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blb.day_20220625_springboot.entity.Person;
import com.blb.day_20220625_springboot.entity.User;

/**
 * @Author Charon
 * @Date 2022/6/25
 **/
public interface IUserService extends IService<User> {
    /**
     * 获取分页数据
     * @param current
     * @param size
     * @return
     */
    IPage<User> getPage(Long current, Long size);
}
