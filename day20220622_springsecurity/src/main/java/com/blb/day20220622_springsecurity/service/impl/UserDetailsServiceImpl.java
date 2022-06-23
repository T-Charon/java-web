package com.blb.day20220622_springsecurity.service.impl;

/**
 * @Author Charon
 * @Date 2022/6/22
 **/

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blb.day20220622_springsecurity.entity.User;
import com.blb.day20220622_springsecurity.mapper.UserMapper;
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

    /**
     * 按用户名查询用户
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", s));
        if(user == null){
            throw  new UsernameNotFoundException("用户不存在！！！");
        }
        //返回用户详情信息
        return new org.springframework.security.core.userdetails.User(s,user.getPassword()
                ,AuthorityUtils.commaSeparatedStringToAuthorityList(""));
    }
}
