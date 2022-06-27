package com.blb.day_20220625_springboot.config;

import com.blb.day_20220625_springboot.utils.ResponseStatus;
import com.blb.day_20220625_springboot.utils.ResposeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


/**
 * @Author Charon
 * @Date 2022/6/22
 **/

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置自定义登录逻辑
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置放行url
        http.authorizeRequests()
                .antMatchers("/login","/logout").permitAll()
                .anyRequest().authenticated()               //配置其它url要验证
                .and()
                .formLogin()                                //配置登录相关
                .successHandler(new LoginSuccessHandler())  //配置登录成功的处理器
                .failureHandler((req,resp,auth) -> {        //配置登录失败的处理器
                    ResposeResult.write(resp, ResposeResult.error(ResponseStatus.LOGIN_ERROR));
                })
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((req,resp,auth) ->{ //配置拦截未登录请求的处理
                    ResposeResult.write(resp,ResposeResult.error(ResponseStatus.AUTHENTICATE_ERROR));
                })
                .and()
                .logout()
                .logoutSuccessHandler((req,resp,auth) ->{     //配置登出处理器
                    ResposeResult.write(resp,ResposeResult.ok("注销成功"));
                })
                .clearAuthentication(true)                     //清除验证缓存
                .and()
                .cors()
                .configurationSource(corsConfigurationSource())// 配置跨域
                .and()
                .csrf()
                .disable()                                    //关闭csrf保护
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //不使用session
                .and()
                .addFilter(new TokenAuthenticationFilter(authenticationManager())); //把token解析过滤器添加到过滤器链中

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        //配置允许访问的服务器域名
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8081",
                "http://localhost:63342"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true); //允许cookie
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); //注册到所有url
        return source;
    }
}
