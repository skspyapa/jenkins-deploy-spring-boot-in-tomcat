package com.example.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Welcome to Spring Boot application deployed on Tomcat!";
    }

    @GetMapping("/api/message")
    public String getMessage() {
        return "This is a sample Spring Boot API running successfully on Tomcat server.";
    }

}
