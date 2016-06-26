package com.spring.controller;

import com.spring.common.validator.Create;
import com.spring.entity.DemoEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/26
 */
@RestController
public class DemoController {

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Object get() {
        return "111";
    }


    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Object post(@RequestBody @Validated(Create.class) DemoEntity demoEntity, Errors errors) throws Exception {
        if (errors.hasFieldErrors()) {
            log("hasFieldErrors");
            throw new Exception(errors.getFieldError().toString());
        } else if (errors.hasGlobalErrors()) {
            throw new Exception(errors.getGlobalError().toString());
        }
        log("post");
        return demoEntity.getAge();
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public Object delete() {
        return "";
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public Object patch() {

        return null;
    }


    private static void log(String str) {
        System.out.println(str);
    }

    private static void log(double str) {
        System.out.println(str);
    }

    private static void log(int str) {
        System.out.println(str);
    }
}
