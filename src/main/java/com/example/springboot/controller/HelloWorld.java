package com.example.springboot.controller;

import com.example.springboot.dto.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RequestBody+ @Controller
// RequesBody => (convert HTTP req to java obj & send to controller)
@RestController
public class HelloWorld {

    // GET => client asks the server to retrieve something (data, message, resource)
    // POST => send data, PUT => update existing resource, PATCH => update part of resource
    // DELETE => remove resource

    // path => where o/p is displayed
    //@RequestMapping(method = RequestMethod.GET, path = "hello-world") => basic way
    @GetMapping(path = "hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    // returns bean
    @GetMapping(path = "hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }


}

// url :http://localhost:8080/hello-world
