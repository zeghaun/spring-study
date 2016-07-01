package com.spring.controller;

import com.spring.common.exception.FieldException;
import com.spring.common.utils.JsonUtil;
import com.spring.common.utils.MessageUtil;
import com.spring.common.validator.Create;
import com.spring.entity.DemoEntity;
import com.spring.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/26
 */
@RestController
@RequestMapping("/${version}/demo")
//@RequestMapping("/v0.1")
public class DemoController {

    @Value("${author}")
    private String author;

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Object get() {

        log(author);
        return "111";
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Object post(@RequestBody @Validated(Create.class) DemoEntity demoEntity, Errors errors) throws Exception {
        if (errors.hasFieldErrors()) {
            throw new FieldException(errors.getFieldError());
        } else if (errors.hasGlobalErrors()) {
            throw new FieldException(errors.getGlobalError());
        }
        log("post");
        log(MessageUtil.getMessage("error.locate"));
        return JsonUtil.toJson(demoEntity);
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
