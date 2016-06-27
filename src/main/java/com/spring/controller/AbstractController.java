/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author DC.L <ivwsai@gmail.com>
 * @version Created by DCL on 12/16/2015
 */
@Component
public abstract class AbstractController {
//    protected Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object get() {
        return "get";
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object post() {
        return "post";
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public Object delete() {
        return "delete";
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public Object patch() {

        return "patch";
    }
}
