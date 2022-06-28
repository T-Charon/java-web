package com.blb.day_20220625_springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.blb.day_20220625_springboot.entity.User;
import com.blb.day_20220625_springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * 用户查询实现类（自定义登录拦截）
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    //返回用户详情信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
       if(user == null){
           throw new UsernameNotFoundException("用户不存在");
       }
        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(username, user.getPassword()
                , AuthorityUtils.commaSeparatedStringToAuthorityList(""));
        System.out.println(user1);
        return user1;
    }
}
