package com.backend.study.user.controller;

import com.backend.study.user.dto.UserDTO;
import com.backend.study.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    public void  registerUser(@RequestBody UserDTO userDTO){
        userService.registerUser(userDTO);
    }
}
