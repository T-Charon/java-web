package com.blb.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 设置配置文件
 */
@ComponentScan("com.blb")
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    //设置默认servlet
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        //中文转换器
        ArrayList<MediaType> list = new ArrayList<>();
        MediaType mediaType = new MediaType("text", "html", StandardCharsets.UTF_8);
        list.add(mediaType);
        stringHttpMessageConverter.setSupportedMediaTypes(list);
        converters.add(stringHttpMessageConverter);

        //自定义消息转化器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        ArrayList<MediaType> list1 = new ArrayList<>();
        MediaType mediaType1 = new MediaType("application", "json", StandardCharsets.UTF_8);
        list1.add(mediaType1);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(list1);
        converters.add(fastJsonHttpMessageConverter);

    }


    /**
     * 视图解析器
     *
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/", ".jsp");
    }


}