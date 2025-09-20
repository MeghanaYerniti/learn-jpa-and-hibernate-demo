package com.example.springboot.entity;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserBean {

    private Integer id;

    @Size(min = 2, max = 20, message = "name should be at least 2 to 20 characters.")
    private String name;
    @Past
    private LocalDate bDay;


}
