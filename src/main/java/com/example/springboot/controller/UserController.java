package com.example.springboot.controller;

import com.example.springboot.entity.UserBean;
import com.example.springboot.repository.UserDaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping("/users")
    public List<UserBean> allBeans() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public UserBean findId(@PathVariable Integer id) {
        return userDaoService.findOne(id);
    }

}
