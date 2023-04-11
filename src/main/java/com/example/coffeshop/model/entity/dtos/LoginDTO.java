package com.example.coffeshop.model.entity.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginDTO {

    @NotBlank
    @Size(min = 5 , max = 20)
    private String userName;

    @NotBlank
    @Size(min = 3)
    private String password;

    public LoginDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public LoginDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
