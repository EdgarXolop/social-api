package com.voider.socialapi.service;

import com.voider.socialapi.dto.UserDTO;
import com.voider.socialapi.http.exception.PasswordMismatchException;
import com.voider.socialapi.model.User;
import com.voider.socialapi.model.UserCredentials;
import com.voider.socialapi.repository.UserRepositoryImpl;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositoryImpl _userRepository;
    @Autowired
    Environment env;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User registerUser(User user) {

        if(!user.getPassword().equals(user.getPassword_confirm())) throw  new PasswordMismatchException("The passwords mismatch.");

        _userRepository.registerUser(user);

        return user;
    }

    @Override
    public User updateUser(String user_name, User user) {
        //TODO: remove updatable false from user model
        User original_user = _userRepository.getUserByEmail(user_name);

        original_user.setFirst_name(user.getFirst_name());
        original_user.setLast_name(user.getLast_name());
        original_user.setDate_of_birth(user.getDate_of_birth());
        original_user.setPhone_number(user.getPhone_number());


        _userRepository.updateUser(original_user);

        return original_user;
    }

    @Override
    public HttpResponse<String> authUser(UserCredentials userCredentials) {

        HttpResponse<String> response = Unirest.post(env.getProperty("oauth2.accessTokenUri"))
                .header("Authorization", "Basic YWNtZTphY21lc2VjcmV0")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "*/*")
                .header("Connection", "keep-alive")
                .queryString("grant_type", "password")
                .queryString("username", userCredentials.getEmail())
                .queryString("password", userCredentials.getPassword())
                .asString();

        return response;
    }

    @Override
    public HttpResponse<String> refreshUser(String refreshToken) {

        HttpResponse<String> response = Unirest.post(env.getProperty("oauth2.accessTokenUri"))
                .header("Authorization", "Basic YWNtZTphY21lc2VjcmV0")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "*/*")
                .header("Connection", "keep-alive")
                .queryString("grant_type", "refresh_token")
                .queryString("username", refreshToken)
                .asString();

        return response;
    }

    @Override
    public HttpResponse<String> checkUser(String token) {

        HttpResponse<String> response = Unirest.post(env.getProperty("oauth2.checkTokenUri"))
                .header("Authorization", "Basic YWNtZTphY21lc2VjcmV0")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Accept", "*/*")
                .header("Connection", "keep-alive")
                .queryString("username", token)
                .asString();

        return response;
    }
}
