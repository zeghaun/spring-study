package com.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    /**
     * /hello?name=abc
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "zeghaun") String name) {
        return "hello:" + name;
    }

    /**
     * /test?id=abc
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String get(@RequestParam("id") String id) {
        System.out.println("test:" + id);
        return "get";
    }

    @RequestMapping(value = "/test/{id}/{id2}")
    public String getRestFul(@PathVariable("id2") String id2, @PathVariable("id") String id) {
        System.out.println("test:" + id + "---" + id2);
        return "getRestFul";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String post() {
        System.out.println("test");
        return "post";
    }

    @RequestMapping(value = "/head", method = RequestMethod.GET, headers = {"refer=abc", "re=123"})
    public String head() {
        System.out.println("head  refer=abc re=123");
        return "head";
    }

    @RequestMapping(value = "/head/{id}", method = RequestMethod.GET, params = "re=123")
    public String headParams(@PathVariable("id") String id) {
        System.out.println("head  Params" + id);
        return "head";
    }

}
