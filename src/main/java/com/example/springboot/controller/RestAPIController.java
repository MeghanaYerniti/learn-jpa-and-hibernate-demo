package com.example.springboot.controller;

import com.example.springboot.entity.HelloBean;
import org.springframework.web.bind.annotation.*;

// to
@RestController // @Controller + @ResponseBody
public class RestAPIController {

    @RequestMapping(method= RequestMethod.GET, path="/RestAPIController")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/GetMappingMethod1")
    public String GetMappingMethod1() {
        return "GetMapping";
    }

    @GetMapping(path = "/GetMappingMethod2")
    public HelloBean GetMappingMethod2() {
        return new HelloBean("GetMapping"); // returning cls as object
    }

    @GetMapping(path = "/GetMappingMethodPathVariables/{name}")  // here {name} is path parameter whose value is passed from browser
    public String GetMappingMethodPathVariables(@PathVariable String name) {
        return "Hello " + name;
    }


}
