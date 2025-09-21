package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@JsonIgnoreProperties("city") // at class level => here ignoring city filed
public class FilteringBean {

    private String name;

    // filed level
    //@JsonIgnore  // this will not return field and value of filed2
    private String password;
    private String city;

}
