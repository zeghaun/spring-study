package com.spring.controller;

import com.spring.config.WebConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/26
 */

//@ContextConfiguration(value = {"classpath:spring/applicationContext.xml"})
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractTest {
    protected static MvcResult mvcResult;
    protected MockMvc mockMvc;

    //需要在webconfig开启这个 @EnableWebMvc
    @Autowired
    protected WebApplicationContext webApplicationContext;

    public void init() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}
