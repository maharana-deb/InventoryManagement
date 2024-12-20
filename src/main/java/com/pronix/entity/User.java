package com.pronix.entity;

import com.pronix.exception.OnLogin;
import com.pronix.exception.OnRegister;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
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

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

}