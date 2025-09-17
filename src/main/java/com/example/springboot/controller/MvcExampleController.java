package com.example.springboot.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcExampleController {

    // no need to have same name for url and html file
    @GetMapping("/home")  // when we open http://localhost:8080/home, this method executes
    public String homePage(Model model) {
        model.addAttribute("message", "Hello, Spring MVC in your project!");
        return "home";  // will map to template/home.html
    }
}
