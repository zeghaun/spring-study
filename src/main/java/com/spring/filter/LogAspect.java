/**
 * @copyright Copyright 1999-2016 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.filter;

import com.spring.entity.DemoEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {

    private long before;

    private long after;

    /**
     * 前置通知（Before advice）在某连接点（JoinPoint）之前执行的通知，但这个通知不能阻止连接点前的执行
     *
     * @param joinPoint
     */
    @Before("execution(public * com.spring.controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void doBefore(JoinPoint joinPoint) {
        // 记录方法开始执行的时间
        before = System.currentTimeMillis();

        DemoEntity d = (DemoEntity) joinPoint.getArgs()[0];
        System.out.println("Aspect doBefore");

    }

    /**
     * 后置通知（After advice）：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出
     *
     * @param joinPoint
     */
    @After("execution(public * com.spring.controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void doAfter(JoinPoint joinPoint) {
        after = System.currentTimeMillis();
        DemoEntity d = (DemoEntity) joinPoint.getArgs()[0];
        log("Aspect doAfter");
    }

    /**
     * 返回后通知（After return advice）：在某连接点正常完成后执行的通知，不包括抛出异常的情况
     *
     * @param joinPoint
     */
    @AfterReturning("execution(public * com.spring.controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void doAfterReturning(JoinPoint joinPoint) {
        log("Aspect doAfterReturning");
    }

    /**
     * 抛出异常后通知（After throwing advice）：在方法抛出异常退出时执行的通知
     *
     * @param joinPoint
     */
    @AfterThrowing("execution(public * com.spring.controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void doAfterThrowing(JoinPoint joinPoint) {
        log("Aspect doAfterThrowing");
    }

    /**
     * 环绕通知（Around advice）：包围一个连接点的通知，类似Web中Servlet规范中的Filter的doFilter方法。可以在方法的调用前后完成自定义的行为，也可以选择不执行
     *
     * @param joinPoint
     * @return
     */
    //@Around("execution(public * com.spring.controller..*.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object doAroud(ProceedingJoinPoint joinPoint) {
        log("Aspece doAroud");


        return null;
    }

    private static void log(String str) {
        System.out.println(str);
    }
}
