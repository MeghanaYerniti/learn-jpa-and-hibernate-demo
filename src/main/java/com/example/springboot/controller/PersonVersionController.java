package com.example.springboot.controller;

import com.example.springboot.entity.Names;
import com.example.springboot.entity.PersonV1;
import com.example.springboot.entity.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

    // versioning using Url
    @GetMapping("/v1/person")
    public PersonV1 GetFirstVersion() {
        return new PersonV1("Abhi");
    }

    @GetMapping("/v2/person")
    public PersonV2 GetSecondVersion() {
        return new PersonV2(new Names("James", "Smith"));
    }

    // versioning using request parameters
    @GetMapping(path = "/person", params = "version=1")  // URL : http://localhost:8080/person?version=1
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1 ("Ram");
    }

    @GetMapping(path = "/person", params = "version=2")  // URL : http://localhost:8080/person?version=1
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        return new PersonV2(new Names("Abhi", "Ram"));
    }

}
