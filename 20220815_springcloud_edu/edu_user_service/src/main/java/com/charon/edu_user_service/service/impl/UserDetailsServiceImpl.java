package com.charon.edu_user_service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.charon.comment.entity.User;
import com.charon.edu_user_service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author Charon
 * @Date 2022/8/11
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //按用户名查询
        User user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUsername, s));
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        //返回正确的用户信息
        return new org.springframework.security.core.userdetails.User(s,user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(""));
    }
}
