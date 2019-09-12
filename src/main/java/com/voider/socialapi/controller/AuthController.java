package com.voider.socialapi.controller;

import com.voider.socialapi.model.User;
import com.voider.socialapi.model.UserCredentials;
import com.voider.socialapi.model.UserDTO;
import com.voider.socialapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService _userService;

    @PostMapping("/login")
    ResponseEntity<String> login(@Valid @RequestBody UserCredentials credentials){

        return new ResponseEntity<>("Login path", HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    ResponseEntity<UserDTO> login(@Valid @RequestBody User user){

        ModelMapper modelMapper = new ModelMapper();

        user = _userService.registerUser(user);

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
    }

}
