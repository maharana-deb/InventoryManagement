package com.pronix.service;

import com.pronix.entity.User;
import com.pronix.exception.AuthenticationFailedException;
import com.pronix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User register(User user) {

        User newUser = new User();

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(encoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());

        return userRepository.save(newUser);

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
}