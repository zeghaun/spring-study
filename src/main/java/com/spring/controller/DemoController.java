package com.spring.controller;

import com.spring.common.exception.FieldException;
import com.spring.common.utils.JsonUtil;
import com.spring.common.validator.groups.Create;
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

    /**
     * [GET]    ?$offset={offset}&$limit={limit}
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Object get(@RequestParam(value = "$offset", defaultValue = "0") int offset,
                      @RequestParam(value = "$limit", defaultValue = "20") int limit) {
        if (limit > 50) {
            limit = 50;
        }
        return demoService.getList(offset, limit);
    }

    /**
     * [POST]
     *
     * @param demoEntity
     * @param errors
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Object post(@RequestBody @Validated(Create.class) DemoEntity demoEntity, Errors errors) throws Exception {
        if (errors.hasFieldErrors()) {
            throw new FieldException(errors.getFieldError());
        } else if (errors.hasGlobalErrors()) {
            throw new FieldException(errors.getGlobalError());
        }
        log(JsonUtil.toJson(demoEntity));
        return demoService.post(demoEntity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public Object delete(@PathVariable(value = "id") String id) {

        return "";
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public Object patch() {

        return null;
    }

    private void log(String str) {
        System.out.println(str);
    }
}
