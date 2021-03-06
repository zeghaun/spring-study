package com.spring.controller;

import com.spring.common.utils.JsonUtil;
import org.apache.commons.lang3.CharEncoding;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * DemoController Tester.
 *
 * @author
 * @version 1.0
 * @since <pre>06/26/2016 18:50</pre>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoControllerTest extends AbstractTest {

    String pre = "/v0.1/demo";

    @Before
    public void before() throws Exception {
        super.init();
    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: get()
     */
    @Test
    public void testGet() throws Exception {
        String url = pre + "?$offset=0&$limit=2";

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.GET, url)
                .characterEncoding(CharEncoding.UTF_8)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultActions result = mockMvc.perform(request);
        mvcResult = result.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();
    }

    /**
     * Method: post(@RequestBody @Validated(Create.class) DemoEntity demoEntity, Errors errors)
     */
    @Test
    public void testPost() throws Exception {
        String url = pre;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "zeg" + System.currentTimeMillis() / (10 ^ 4));
        map.put("age", 16);
        map.put("remark", System.currentTimeMillis());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.POST, url)
                .characterEncoding(CharEncoding.UTF_8)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);


        request.content(JsonUtil.toJson(map));
        System.out.println(JsonUtil.toJson(map));

        ResultActions result = mockMvc.perform(request);
        mvcResult = result.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isCreated())
                .andReturn();
    }

    /**
     * Method: delete()
     */
    @Test
    public void testDelete() throws Exception {
        String url = pre + "/12";

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.DELETE, url)
                .characterEncoding(CharEncoding.UTF_8)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultActions result = mockMvc.perform(request);
        mvcResult = result.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();
    }

    /**
     * Method: patch()
     */
    @Test
    public void testPatch() throws Exception {
        String url = pre;

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.PATCH, url)
                .characterEncoding(CharEncoding.UTF_8)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        ResultActions result = mockMvc.perform(request);
        mvcResult = result.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();
    }


    /**
     * Method: log(String str)
     */
    @Test
    public void testLogStr() throws Exception {
        //TODO: Test goes here...
        /*
        try {
           Method method = DemoController.getClass().getMethod("log", String.class);
           method.setAccessible(true);
           method.invoke(<Object>, <Parameters>);
        } catch(NoSuchMethodException e) {
        } catch(IllegalAccessException e) {
        } catch(InvocationTargetException e) {
        }
        */
    }
}
