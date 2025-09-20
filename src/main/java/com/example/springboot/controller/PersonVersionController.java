package com.example.springboot.controller;

import com.example.springboot.entity.Names;
import com.example.springboot.entity.PersonV1;
import com.example.springboot.entity.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

    @GetMapping("/v1/person")
    public PersonV1 GetFirstVersion() {
        return new PersonV1("Abhi");
    }

    @GetMapping("/v2/person")
    public PersonV2 GetSecondVersion() {
        return new PersonV2(new Names("James", "Smith"));
    }

}
