package com.example.coffeshop.model.entity.dtos;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegistrationDTO {

    // Ctl + space показва анотациите
    @NotBlank
    @Size(min = 5, max = 20)
    private String userName;

    private String firstName;
    @NotBlank
    @Size(min = 5, max = 20)
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 3)
    private String password;
    @NotBlank
    @Size(min = 3)
    private String confirmPassword;

    public UserRegistrationDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public UserRegistrationDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegistrationDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegistrationDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "UserRegistrationDTO{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
