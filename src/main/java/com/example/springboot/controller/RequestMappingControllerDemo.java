package com.example.springboot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RequestMappingControllerDemo {

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String hello() {
        return "Hello from GET";
    }

    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public String createHello() {
        return "Hello created!";
    }
}
