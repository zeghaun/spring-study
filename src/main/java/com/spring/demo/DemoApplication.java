package com.spring.demo;

import com.spring.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class DemoApplication {


    @RequestMapping("/demo")
    public String hello() {
        return "demo";
    }


    public static void main(String[] args) {
        SpringApplication.run(new Class[]{DemoApplication.class, HelloController.class}, args);
    }
}
