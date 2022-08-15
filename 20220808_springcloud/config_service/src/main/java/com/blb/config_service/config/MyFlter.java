package com.blb.config_service.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author Charon
 * @Date 2022/8/12
 **/
@Slf4j
@WebFilter(filterName = "bodyFilter", urlPatterns = "/*")
@Order(1)
public class MyFlter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        String url = new String(httpServletRequest.getRequestURI());
        //只过滤/actuator/refresh请求
        if (!url.endsWith("/actuator/bus-refresh")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        log.info("过滤{}",httpServletRequest.getRequestURI());

        //使用HttpServletRequest包装原始请求达到修改post请求中body内容的目的
        CustometRequestWrapper requestWrapper = new CustometRequestWrapper(httpServletRequest);
        filterChain.doFilter(requestWrapper, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
