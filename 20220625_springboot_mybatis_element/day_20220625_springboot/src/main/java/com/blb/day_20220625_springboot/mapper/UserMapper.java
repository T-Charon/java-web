package com.blb.day_20220625_springboot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.blb.day_20220625_springboot.entity.Person;
import com.blb.day_20220625_springboot.entity.User;

/**
 * @Author Charon
 * @Date 2022/6/25
 **/
public interface UserMapper extends BaseMapper<User> {
    /**
     *
     * @param page
     * @return
     */
    IPage<User> selectUserPage(IPage<User> page);
}
