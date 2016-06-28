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
        /**
         * 指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc
         * standaloneSetup 通过参数指定一组控制器，这样就不需要从上下文获取了
         * 所以这里必须使用webApplicationContext,才能是使控制器生效
         */
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}
