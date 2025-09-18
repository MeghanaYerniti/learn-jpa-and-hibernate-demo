package com.example.springboot.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MvcExampleController {

    // no need to have same name for url and html file
    @GetMapping("/hello")// when we open http://localhost:8080/hello, this method executes
    @ResponseBody
    public String homePage() {
        return "Spring MVC";
    }
}
