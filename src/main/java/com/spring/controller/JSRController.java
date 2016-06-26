package com.spring.controller;

import com.spring.entity.People;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Administrator on 2015/12/21.
 */
@RestController
public class JSRController {
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/jsr", method = POST)
    public String jsr(@RequestBody People people, Errors errors) throws Exception {
        if (errors.hasFieldErrors()) {
            throw new Exception(errors.getFieldError().toString());
        } else if (errors.hasGlobalErrors()) {
            throw new Exception(String.valueOf(errors.hasGlobalErrors()));
        }

//        System.out.println(errors.hasFieldErrors());
        System.out.println("zeghaun post");
        System.out.println(people.getAge() + " -post- " + people.getName());

        return "yes";
    }

    @RequestMapping(value = "/jsr", method = GET)
    public String jsrGet() {
        System.out.println("zeghaun hahaha get");

        return "yes";

    }

    @RequestMapping(value = "/jsr", method = GET)
    public String post() {
        System.out.println("zeghaun post");
        return "post";
    }
}
