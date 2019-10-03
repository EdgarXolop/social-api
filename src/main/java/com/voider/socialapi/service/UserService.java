package com.voider.socialapi.service;

import com.voider.socialapi.model.User;
import com.voider.socialapi.model.UserCredentials;
import kong.unirest.HttpResponse;

public interface UserService {

    public User registerUser(User user);
    public HttpResponse<String> authUser(UserCredentials userCredentials);
    public HttpResponse<String> refreshUser(String refreshToken);
    public HttpResponse<String> checkUser(String token);
}
