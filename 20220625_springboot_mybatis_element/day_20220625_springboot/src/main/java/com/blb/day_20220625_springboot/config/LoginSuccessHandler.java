package com.blb.day_20220625_springboot.config;

import com.blb.day_20220625_springboot.entity.vo.UserVo;
import com.blb.day_20220625_springboot.utils.JwtUtil;
import com.blb.day_20220625_springboot.utils.ResposeResult;
import com.blb.day_20220625_springboot.utils.RsaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理器
 */
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //获得用户名
        User user = (User) authentication.getPrincipal();
        //将用户名生成jwt token
        String token = JwtUtil.generateToken(user.getUsername(), RsaUtil.privateKey, JwtUtil.EXPIRE_MINUTES);
        //将token 发送给前端

        UserVo userVo = new UserVo(user.getUsername(),token);

        ResposeResult.write(response,ResposeResult.ok(userVo));
        log.info("user:{}  token:{}",user.getUsername() , token);
    }
}
