package com.voider.socialapi.service;

import com.voider.socialapi.model.User;
import com.voider.socialapi.model.UserCredentials;

public interface UserService {

    public User registerUser(User user);
    public User authUser(UserCredentials userCredentials);
}
