package com.pronix.entity;

import com.pronix.exception.OnLogin;
import com.pronix.exception.OnRegister;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(groups = OnRegister.class, message = "First name can not be null. Please check.")
    @NotBlank(groups = OnRegister.class, message = "First name can not be blank. Please check.")
    private String firstName;

    @NotNull(groups = OnRegister.class, message = "Last name can not be null. Please check.")
    @NotBlank(groups = OnRegister.class, message = "Last name can not be blank. Please check.")
    private String lastName;

    @NotNull(groups = {OnRegister.class, OnLogin.class}, message = "Username can not be null. Please check.")
    @NotBlank(groups = {OnRegister.class, OnLogin.class}, message = "Username can not be blank. Please check.")
    private String username;

    @NotNull(groups = {OnRegister.class, OnLogin.class}, message = "Password can not be null. Please check.")
    @NotBlank(groups = {OnRegister.class, OnLogin.class}, message = "Password can not be blank. Please check.")
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

}