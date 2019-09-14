package com.voider.socialapi.controller;

import com.voider.socialapi.model.User;
import com.voider.socialapi.dto.UserDTO;
import com.voider.socialapi.repository.UserRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepositoryImpl _userRepository;

    @GetMapping(value = "/username")
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }


    @GetMapping(value = "/profile")
    @ResponseBody
    public ResponseEntity<UserDTO> getInfo(Authentication authentication) {

        User user = _userRepository.getUserByEmail(authentication.getName());

        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return new ResponseEntity<>(userDTO, HttpStatus.ACCEPTED);

    }

    @GetMapping(value = "/list")
    @ResponseBody
    public ResponseEntity<List<UserDTO>> listUsers() {

        List<UserDTO> users = new ArrayList<>();

//        ModelMapper modelMapper = new ModelMapper();
//        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);

    }

}
