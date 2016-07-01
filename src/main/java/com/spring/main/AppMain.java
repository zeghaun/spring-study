package com.spring.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/26
 */
public class AppMain {
    @Value("${environment}")
    private static String environment;

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/applicationContext.xml"});

        HelloWorld helloWorld = (HelloWorld) context.getBean("testHello");
        helloWorld.printHello();
    }

    private void haha() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/SpringBeans.xml"});

        HelloWorld helloWorld = (HelloWorld) context.getBean("helloBean");
        helloWorld.printHello();

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
