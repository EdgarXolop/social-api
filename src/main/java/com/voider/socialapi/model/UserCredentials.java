package com.voider.socialapi.model;

import com.voider.socialapi.util.ValidationMessages;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Model to get the user credentials received
 */
public class UserCredentials {

    @NotNull(message = ValidationMessages.EMPTY_EMAIL)
    @NotEmpty(message = ValidationMessages.EMPTY_EMAIL)
    @NotBlank(message = ValidationMessages.EMPTY_EMAIL)
    private String email;

    @NotNull(message = ValidationMessages.EMPTY_PASSWORD)
    @NotEmpty(message = ValidationMessages.EMPTY_PASSWORD)
    @NotBlank(message = ValidationMessages.EMPTY_PASSWORD)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
