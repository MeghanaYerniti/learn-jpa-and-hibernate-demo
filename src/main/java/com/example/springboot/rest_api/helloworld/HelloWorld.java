package com.example.springboot.rest_api.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @RequestBody+ @Controller
// RequesBody => (convert HTTP req to java obj & send to controller)
@RestController
public class HelloWorld {

    // RequestMethod =>
    // GET => client asks the server to retrieve something (data, message, resource)
    // POST => send data, PUT => update existing resource, PATCH => update part of resource
    // DELETE => remove resource

    // path => where o/p is displayed
    @RequestMapping(method = RequestMethod.GET, path = "hello-world")
    public String helloWorld() {
        return "Hello World";
    }
}

// url :http://localhost:8080/hello-world
