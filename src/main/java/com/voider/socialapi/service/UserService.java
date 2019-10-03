package com.voider.socialapi.service;

import com.voider.socialapi.model.User;
import com.voider.socialapi.model.UserCredentials;

public interface UserService {

    public User registerUser(User user);
    public String authUser(UserCredentials userCredentials);
    public String refreshUser(String refreshToken);
    public String checkUser(String token);
}
