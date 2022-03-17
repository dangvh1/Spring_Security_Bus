package com.example.Spring_Security_Bus.controller;

import com.example.Spring_Security_Bus.DTO.UsersDTO;
import com.example.Spring_Security_Bus.service.UserServiceSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    UserServiceSystem userServiceSystem;

    @Autowired
    BCryptPasswordEncoder encoder;

    @PostMapping("/register")
    public UsersDTO register(@RequestBody UsersDTO usersDTO){
        usersDTO.setPassword(encoder.encode(usersDTO.getPassword()));
        userServiceSystem.create(usersDTO);
        return usersDTO;
    }
}
