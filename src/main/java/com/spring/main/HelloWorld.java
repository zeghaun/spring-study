package com.spring.main;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {

    public String name;

    public void setName(String name) {
        this.name = name;
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