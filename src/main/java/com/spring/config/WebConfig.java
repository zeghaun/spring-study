/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

/**
 * JavaConfig方式的spring配置类
 */
@Configuration
@EnableWebMvc
@ImportResource(value = {"classpath:spring/applicationContext.xml"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);

        //注册国际化支持的拦截器
        registry.addInterceptor(new LocaleChangeInterceptor());
    }


    /**
     * 配置访问html页面和静态资源扩展demo
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/html/**").addResourceLocations("/html/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }
}