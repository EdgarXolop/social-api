package com.voider.socialapi.controller;

import com.voider.socialapi.model.User;
import com.voider.socialapi.model.UserCredentials;
import com.voider.socialapi.dto.UserDTO;
import com.voider.socialapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService _userService;

    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<String> login(@Valid @RequestBody UserCredentials credentials){

        return new ResponseEntity<>(_userService.authUser(credentials), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/refresh",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<String> refreshUser(@RequestParam("refresh_token") String refreshToken){

        return new ResponseEntity<>(_userService.refreshUser(refreshToken), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/check",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<String> checkUser(@RequestParam("token") String token){

        return new ResponseEntity<>(_userService.checkUser(token), HttpStatus.ACCEPTED);
    }

    @PostMapping("/register")
    ResponseEntity<UserDTO> register(@Valid @RequestBody User user) {

        user = _userService.registerUser(user);

        ModelMapper modelMapper = new ModelMapper();

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);
    }

}
