package com.blb.day20220622_springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * @Author Charon
 * @Date 2022/6/22
 **/

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 配置编码器对象
     * @return
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    /**
     * 用户登录验证的配置
     * @param auth
     * @throws Exception
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用自定义的用户逻辑对象配置验证对象
        auth.userDetailsService(userDetailsService);
    }

    /**
     * 页面的配置和访问控制配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//请求授权配置
                .antMatchers("/login").permitAll()  //登录页面放行
                .anyRequest().authenticated()   //其它URL都要验证
                .and()
                .formLogin()    //登录页面配置
                .loginPage("/login")    //自定义登录页面的路径
                .loginProcessingUrl("/doLogin") //配置自定义登录处理的URL
                .defaultSuccessUrl("/index")    //登录成功跳转的路径
                .and()
                .logout()   //注销配置
                .logoutUrl("logout")
                .logoutSuccessUrl("/login");

        http.rememberMe()   //配置记住我
                .rememberMeParameter("rememberMe")  //表单中的名称
                .tokenRepository(persistentTokenRepository) //jdbc操作对象
                .tokenValiditySeconds(60*60);  //记住我的时间为1小时
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/js/**", "/css/**","/image/**");
    }
}
