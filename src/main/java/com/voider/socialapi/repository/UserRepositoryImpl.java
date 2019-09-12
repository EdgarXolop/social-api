package com.voider.socialapi.repository;

import com.voider.socialapi.exception.ResourceNotFound;
import com.voider.socialapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl {

    @Autowired
    UserRepository _userRepository;

    public User getUserByEmail(String email){
        User user = _userRepository.findByEmail(email);

        if(user == null) new ResourceNotFound("Couldn't find a User with the email: " + email);

        return user;
    }

    public User getUserByUserName(String userName){
        User user = _userRepository.findByUserName(userName);

        if(user == null) new ResourceNotFound("Couldn't find a User with the username: " + userName);

        return user;
    }

    public User registerUser(User user){
        _userRepository.save(user);

        System.out.println("user id "+ user.getId_user());
        return user;
    }
}
