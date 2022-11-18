package com.itheima.config;

import com.itheima.controller.interceptor.Projectinterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    //将拦截器注册到SpringBoot中
    @Autowired
    Projectinterceptor projectInterceptor;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //先拦截所有请求
        registry.addInterceptor(projectInterceptor).addPathPatterns("/**")
                //对登陆页面和静态资源进行放行
                .excludePathPatterns(
                        //放行静态资源js,css,图片等
                        "/css/**",
                        "/plugins/**",
                        "/imgs/**",
                        "/js/**",
                        //放行请求
                        "/user/**",//登陆请求
                        "/pages/login.html",//登陆页面
                        "/pages/register.html",//登陆验证请求
                        "/houses/**"
                );
    }

    //必须要自定义资源文件路径
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
}