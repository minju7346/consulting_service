package com.backend.study.user.controller;

import com.backend.study.user.dto.UserDTO;
import com.backend.study.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public void  register(@RequestBody UserDTO userDTO){
        userService.register(userDTO);
        userService.registerHistory(userDTO.getId());
    }
}

