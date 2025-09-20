package com.example.springboot.entity;

import lombok.Getter;

@Getter
public class HelloBean {
    private String msg;
    public HelloBean(String msg) {
        this.msg = msg;
    }
}
