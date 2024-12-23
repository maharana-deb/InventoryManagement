package com.pronix.service;

import com.pronix.dto.UserDto;
import com.pronix.entity.User;

import java.util.List;

public interface UserService {

    UserDto register(User user);
    String verify(User user);
    UserDto updateUser(Integer id, User newUser);
    List<UserDto> getAllUsers();
    UserDto getUserById(String id);
    String deleteUser(Integer id);

}
