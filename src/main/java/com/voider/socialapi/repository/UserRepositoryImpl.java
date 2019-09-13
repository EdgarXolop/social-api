package com.voider.socialapi.repository;

import com.voider.socialapi.http.exception.ResourceNotFoundException;
import com.voider.socialapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl {

    @Autowired
    public PasswordEncoder encoder;

    @Autowired
    UserRepository _userRepository;

    public User getUserByEmail(String email){
        User user = _userRepository.findByEmail(email);

        if(user == null) throw new ResourceNotFoundException("Couldn't find a User with the email: " + email);

        return user;
    }

    public User getUserByUserName(String userName){
        User user = _userRepository.findByUserName(userName);

        if(user == null) throw new ResourceNotFoundException("Couldn't find a User with the username: " + userName);

        return user;
    }

    public User registerUser(User user){

        user.setPassword(encoder.encode(user.getPassword()));

        _userRepository.save(user);

        System.out.println("user id "+ user.getId_user());
        return user;
    }
}
