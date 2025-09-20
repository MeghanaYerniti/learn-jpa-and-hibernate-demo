package com.example.springboot.controller;

import com.example.springboot.dto.HelloWorldBean;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

// @RequestBody+ @Controller
// RequesBody => (convert HTTP req to java obj & send to controller)
@AllArgsConstructor
@RestController
public class HelloWorld {

    private MessageSource messageSource;



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

    // internationalization - i18n
    // add messages.properties file in resources folder => default message
    // add message_nl.properties => Duch (Goedemorgen)
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);

    }

}

// url :http://localhost:8080/hello-world
