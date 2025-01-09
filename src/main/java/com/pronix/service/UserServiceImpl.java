package com.pronix.service;

import com.pronix.dto.UserDto;
import com.pronix.entity.User;
import com.pronix.exception.AuthenticationFailedException;
import com.pronix.exception.BadRequestException;
import com.pronix.exception.ResourceNotFoundException;
import com.pronix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserDto register(User user) {

        User newUser = new User();

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());

        User regUser = userRepository.save(newUser);

        return new UserDto(regUser.getFirstName(), regUser.getLastName(), regUser.getUsername(), regUser.getId());

    }

    public String verify(User user) {

        try{
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            return jwtService.generateToken(user.getUsername());
        } catch(BadCredentialsException exception){
            throw new AuthenticationFailedException("Incorrect username or password. Please check it once.");
        } catch(Exception exception){
            throw new AuthenticationFailedException("Authentication failed due to an unexpected error.");
        }

    }

    public UserDto updateUser(Integer id, User newUser){

        User user = userRepository.findById(id).orElse(null);

        if(user == null){
            throw new ResourceNotFoundException("Couldn't find any user with the provided id.");
        } else {
            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setUsername(newUser.getUsername());
            user.setPassword(encoder.encode(newUser.getPassword()));
            user.setRole(newUser.getRole());

            User updatedUser = userRepository.save(user);

            return new UserDto(updatedUser.getFirstName(), updatedUser.getLastName(), updatedUser.getUsername(), updatedUser.getId());

        }

    }

    public List<UserDto> getAllUsers(){

        List<User> users = userRepository.findAll();

        List<UserDto> userDtos = users.stream()
                .map(user -> new UserDto(
                        user.getFirstName(),
                        user.getLastName(),
                        user.getUsername(),
                        user.getId()
                ))
                .collect(Collectors.toList());

        return userDtos;
    }

    public UserDto getUserById(String id){

        if(id == null || id.trim().isEmpty() || !id.matches("\\d+")){
            throw new BadRequestException("Invalid user id, the id should be a number only.");
        }
        User user = userRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find any user with the provided id."));

        return new UserDto(user.getFirstName(), user.getLastName(), user.getUsername(), user.getId());

    }

    public String deleteUser(Integer id){

        if(!userRepository.existsById(id)){
            throw new ResourceNotFoundException("Couldn't find any user with the provided id.");
        } else {
            userRepository.deleteById(id);
            return "User removed from Database!";
        }

    }

}