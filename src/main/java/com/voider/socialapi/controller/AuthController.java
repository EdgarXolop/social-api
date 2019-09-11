package com.voider.socialapi.controller;

import com.voider.socialapi.model.User;
import com.voider.socialapi.model.UserCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    ResponseEntity<String> login(UserCredentials credentials){

        return new ResponseEntity<>("Login path", HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    ResponseEntity<String> login(User user){

        return new ResponseEntity<>("Register path", HttpStatus.ACCEPTED);
    }

}
