/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author DC.L <ivwsai@gmail.com>
 * @version Created by DCL on 12/16/2015
 */
public abstract class AbstractController {
//    protected Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object get(@RequestParam("id") String id) {
        return "";
    }


    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object post() {
        return "";
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public Object delete() {
        return "";
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH)
    public Object patch() {

        return null;
    }
}
