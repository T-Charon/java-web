package com.blb.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //创建一个容器
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        //配置spring文件
        context.register(WebConfig.class);
        //设置DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        ServletRegistration.Dynamic app = servletContext.addServlet("app", dispatcherServlet);

        app.addMapping("/");

        //设置文件上传
        app.setMultipartConfig(new MultipartConfigElement("/"));
    }


}
