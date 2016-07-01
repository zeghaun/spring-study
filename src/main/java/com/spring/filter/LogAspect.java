/**
 * @copyright Copyright 1999-2016 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.filter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author DC.L <ivwsai@gmail.com>
 * @version Created by DCL on 5/3/2016
 */
@Aspect
@Component
public class LogAspect {

    private long before;

    private long after;

    @Before("execution(public * com.spring.controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void doBefore(JoinPoint joinPoint) {
        // 记录方法开始执行的时间
        before = System.currentTimeMillis();
        System.out.println("Aspect doBefore");
    }

    @After("execution(public * com.spring.controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void doAfter(JoinPoint joinPoint) {
        after = System.currentTimeMillis();
        log("Aspect doAfter");

    }

    @Around("execution(public * com.spring.controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object doAroud(ProceedingJoinPoint joinPoint) {
        log("Aspece doAroud");


        return null;
    }

    private static void log(String str) {
        System.out.println(str);
    }
}