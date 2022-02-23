package com.backend.study.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.backend.study.user.model.UserDTO;
import com.backend.study.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public void  register(@RequestBody UserDTO userDTO){

        userService.register(userDTO);
    }

    @PostMapping("/user-login")
    public void loginUser(@RequestBody UserDTO userDTO, HttpServletResponse response){
        String check;
        check = userService.login(userDTO);
        if (check != null) {
            Cookie cookie = new Cookie("id", userDTO.getId());
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
        }
    }

    @PatchMapping("/user-status")
    public void changeStatus(@RequestBody UserDTO userDTO){

        userService.chanageStatus(userDTO);
    }

}

