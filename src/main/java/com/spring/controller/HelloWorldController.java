package com.spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "123") String name, Model model) {
        model.addAttribute("name11", name);
        System.out.println("zeg:" + name);
        return "helloworld";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String get(@RequestParam("id") String id, Model model) {
        model.addAttribute("idid", id);

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
    public String headParams(@PathVariable String id) {
        System.out.println("head  Params" + id);
        return "head";
    }

}
