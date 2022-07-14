package com.blb.day_20220625_springboot.config;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import com.blb.day_20220625_springboot.utils.JwtUtil;
import com.blb.day_20220625_springboot.utils.RsaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Token验证过滤器
 */
@Slf4j
public class TokenAuthenticationFilter extends BasicAuthenticationFilter {

    public static final String HEADER = "Authorization";

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获得请求头中的token
        String token = request.getHeader(HEADER);
        if(StringUtils.isEmpty(token)){
            //获得参数中的token
            token = request.getParameter(HEADER);
        }
        //如果没有token，放行，验证失败
        if(StringUtils.isEmpty(token)){
            chain.doFilter(request,response);
            return;
        }
        try {
            //如果有token，就进行解析
            String username = JwtUtil.getUsernameFromToken(token, RsaUtil.publicKey);
            //判断用户名是否为空
            if(username != null){
                User user = new User(username,"",AuthorityUtils.commaSeparatedStringToAuthorityList(""));
                //如果解析得到的用户名正确，就创建通过验证的token
                UsernamePasswordAuthenticationToken uToken =
                        new UsernamePasswordAuthenticationToken(user,"",
                                AuthorityUtils.commaSeparatedStringToAuthorityList(""));
                //把验证token放到Security环境中
                SecurityContextHolder.getContext().setAuthentication(uToken);
            }
        }catch (Exception ex){
            log.error("token验证出现错误",ex);
        }
        chain.doFilter(request,response);
    }
}
