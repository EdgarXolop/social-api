package com.voider.socialapi.service;

import com.voider.socialapi.http.exception.PasswordMismatchException;
import com.voider.socialapi.model.User;
import com.voider.socialapi.model.UserCredentials;
import com.voider.socialapi.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositoryImpl _userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User registerUser(User user) {

        if(!user.getPassword().equals(user.getPassword_confirm())) throw  new PasswordMismatchException("The passwords mismatch.");

        _userRepository.registerUser(user);

        return user;
    }

    @Override
    public User authUser(UserCredentials userCredentials) {
        return null;
    }
}
