package com.charon.edu_user_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.charon.comment.entity.User;
import com.charon.edu_user_service.service.UserService;
import com.charon.edu_user_service.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




