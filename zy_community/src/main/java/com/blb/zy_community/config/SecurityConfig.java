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

    /**
     * 页面资源的授权
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //对请求进行授权
        http
                .authorizeRequests()
                .antMatchers(
                        "/swagger-ui.html","/v2/**","/swagger-resources/**","/webjars/springfox-swagger-ui/**", //放行swagger相关
                        "/js/**","/css/**", //放行静态资源
                        "/login","logout"  //放行登录和登出
                )
                .permitAll()
                .anyRequest()
                .authenticated()  //其它的请求需要登录
                .and()
                .formLogin()//登录配置
                .successHandler(new LoginSuccessHandler()) //登录成功处理
                .failureHandler((req,resp,auth) -> {//进行登录失败的处理
                    ResposeResult.write(resp,ResposeResult.error(ResponseStatus.LOGIN_ERROR));
                })
                .and()
                .exceptionHandling() //未进行登录请求的处理
                .authenticationEntryPoint((req,resp,auth)->{
                    ResposeResult.write(resp,ResposeResult.error(ResponseStatus.AUTHENTICATE_ERROR));
                })
                .and()
                .logout()//登出配置
                .logoutSuccessHandler((req,resp,auth) -> {
                    ResposeResult.write(resp, ResposeResult.ok("注销成功"));
                })
                .clearAuthentication(true)
                .and()
                .cors() //跨域配置
                .configurationSource(corsConfigurationSource())
                .and()
                .csrf()
                .disable() //关闭CSRF防御
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //不使用session
                .and()
                .addFilter(new TokenAuthenticationFilter(authenticationManager())); //添加token验证过滤器
    }


    /**
     * 跨域配置对象
     * @return
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        //配置允许访问的服务器域名
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8081",
                "http://localhost:63342",
                "http://www.jdd.com"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
