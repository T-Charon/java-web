package com.charon.edu_user_service.config;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.charon.comment.util.JwtUtil;
import com.charon.comment.util.ResponseResult;
import com.charon.comment.util.RsaUtil;
import com.charon.edu_user_service.entity.UserTokenVO;
import com.charon.edu_user_service.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/11
 **/
@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //获得用户名
        User user = (User) authentication.getPrincipal();
        //获取所有用户信息
        com.charon.comment.entity.User userinfo = userMapper.selectOne(new QueryWrapper<com.charon.comment.entity.User>().lambda().eq(com.charon.comment.entity.User::getUsername, user.getUsername()));
        System.out.println(user);
        //将用户名生成jwt token
        String token = JwtUtil.generateToken(user.getUsername(), RsaUtil.privateKey, JwtUtil.EXPIRE_MINUTES);
        //将token 发送给前端
        UserTokenVO userTokenVo = new UserTokenVO(user.getUsername(),token,userinfo);
        ResponseResult.write(response,ResponseResult.ok(userTokenVo));
        log.info("username:{}  token:{} userinfo:{}",user.getUsername() ,token,userinfo);
    }

}
