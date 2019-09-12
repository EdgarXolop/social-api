package com.voider.socialapi.model;

import javax.validation.constraints.NotNull;

/**
 * Model to get the user credentials received
 */
public class UserCredentials {
    @NotNull
    private String email;
    @NotNull
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
