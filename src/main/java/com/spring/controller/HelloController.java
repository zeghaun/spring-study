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
     * /test?name=abc
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String get(@RequestParam("name") String name) {
        System.out.println("hello:" + name);
        return "get:" + name;
    }

    @RequestMapping(value = "/hello/{id}/{id2}",method = RequestMethod.GET)
    public String getRestFul(@PathVariable("id2") String id2, @PathVariable("id") String id) {
        System.out.println("hello:" + id + "---" + id2);
        return "hello";
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

    private void log(String str) {
        System.out.println(str);
    }

    private void log() {
        log("");
    }
}
