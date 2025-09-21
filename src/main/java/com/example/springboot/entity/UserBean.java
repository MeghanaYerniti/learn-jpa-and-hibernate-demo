package com.example.springboot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="user_details")
public class UserBean {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 2, max = 20, message = "name should be at least 2 to 20 characters.")
    @JsonProperty("user_name")
    private String name;
    @Past
    private LocalDate bDay;


}
