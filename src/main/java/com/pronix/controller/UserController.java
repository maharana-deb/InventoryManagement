package com.pronix.controller;

import com.pronix.dto.UserDto;
import com.pronix.entity.User;
import com.pronix.exception.OnLogin;
import com.pronix.exception.OnRegister;
import com.pronix.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/register")
    public UserDto register(@Validated(OnRegister.class) @RequestBody User user) {
       return userServiceImpl.register(user);
    }

    @PostMapping("/login")
    public String login(@Validated(OnLogin.class) @RequestBody User user){
        return userServiceImpl.verify(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id, @RequestBody User user){
        UserDto updatedUser = userServiceImpl.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUser(){
        return userServiceImpl.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String id){
        UserDto user = userServiceImpl.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        String message = userServiceImpl.deleteUser(id);
        return ResponseEntity.ok(message);
    }

}