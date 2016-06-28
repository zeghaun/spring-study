package com.spring.controller;

import org.apache.commons.lang3.CharEncoding;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * HelloWorldController Tester.
 *
 * @author
 * @version 1.0
 * @since <pre>06/26/2016 11:38</pre>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HelloControllerTest extends AbstractTest {

    @Autowired
    private HelloController controller;


    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: hello(@RequestParam(value = "name", required = false, defaultValue = "123") String name, Model model)
     */
    @Test
    public void testHello() throws Exception {
        String url = "/hello";

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.request(HttpMethod.GET, url)
                .characterEncoding(CharEncoding.UTF_8)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        ResultActions result = mockMvc.perform(request);
        mvcResult = result.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();
    }

    /**
     * Method: get(@RequestParam("id") String id, Model model)
     */
    @Test
    public void testGet() throws Exception {
        //TODO: Test goes here...
    }

}
