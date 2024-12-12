package com.pronix.controller;

import com.pronix.entity.User;
import com.pronix.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@Valid @RequestBody User user) {
       return service.register(user);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody User user){
        return service.verify(user);
    }

}