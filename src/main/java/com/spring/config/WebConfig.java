/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.config;

import com.spring.interceptor.ControllerInterceptor;
import com.spring.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * JavaConfig方式的spring配置类
 * <p/>
 * 1.必须有这个类，tomcat跑起来的时候，EL表达式才生效。我也搞不懂为什么
 */
@Configuration
@EnableWebMvc
@ImportResource(value = {"classpath:spring/applicationContext.xml"})
//@ImportResource(value = {"classpath:test/applicationContext-jpa.xml"})
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addWebRequestInterceptor(new RequestInterceptor());

        //注册国际化支持的拦截器
        registry.addInterceptor(new ControllerInterceptor());
        super.addInterceptors(registry);
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