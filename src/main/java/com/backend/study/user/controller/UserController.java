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
    public void  registerUser(@RequestBody UserDTO userDTO){
        userService.registerUser(userDTO);
    }

    @PostMapping("/user-login")
    public void loginUser(@RequestBody UserDTO userDTO, HttpServletResponse response){
        String check;
        check = userService.loginUser(userDTO);
        if (check != null) {
            Cookie cookie = new Cookie("id", userDTO.getId());
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        }
    }
}

