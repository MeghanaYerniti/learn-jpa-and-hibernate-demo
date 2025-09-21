package com.example.springboot.controller;

import com.example.springboot.entity.UserBean;
import com.example.springboot.exception.UserNotFoundException;
import com.example.springboot.repository.UserDaoService;
import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import jakarta.validation.Valid;

import java.net.URI;
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
    public EntityModel<UserBean> findId(@PathVariable Integer id) {
        UserBean foundUser =userDaoService.findOne(id);
        if(foundUser == null){
            throw new UserNotFoundException("id:"+id);
        }
        EntityModel<UserBean> entityModel = EntityModel.of(foundUser);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).allBeans());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

//    @PostMapping("/users")
//    public void createUser(@RequestBody UserBean userBean) {
//        userDaoService.addUser(userBean);
//    }

//    // returning response status
//    @PostMapping("/users")
//    public ResponseEntity<Object> createUser(@RequestBody UserBean userBean) {
//        userDaoService.addUser(userBean);
//        return ResponseEntity.created(null).build(); // send 201 as response
//    }

    // returning url and Id
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserBean userBean) { // adding validation constraints at bean
        UserBean savedUser = userDaoService.addUser(userBean);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/users/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build(); // sends where created and id
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Integer id) {
        userDaoService.deleteById(id);
    }

}
