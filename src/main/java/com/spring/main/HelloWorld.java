package com.spring.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class HelloWorld {

    @Value("${demo.ver}")
    public String name;

    public void setName(String name) {
        this.name = name;
    }

    @RequestMapping("/login")
    public void queryUsers() {
        System.out.println("name:" + name);
    }

    public void printHello() {
        System.out.println("第一个Spring4 : Hello ! " + name);
    }

    public static HelloWorld createInstance() {
        System.out.println("createInstance");
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("zeghaun");
        return helloWorld;

    }

    public void initMethod() {
        System.out.println("init Method");
    }
}