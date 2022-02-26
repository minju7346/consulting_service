package com.backend.study.user.controller;

import static com.backend.study.user.model.enums.UserStatus.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.backend.study.user.model.UserDTO;
import com.backend.study.user.model.enums.UserStatus;
import com.backend.study.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController{

    @Autowired
    private UserService userService;

    private final int COOKIE_AGE = 60 * 60 * 24 * 30;

    @PostMapping("/user")
    public void  register(@RequestBody UserDTO userDTO){

        userService.register(userDTO);
    }

    @PostMapping("/user-login")
    public void loginUser(@RequestBody UserDTO userDTO, HttpServletResponse response){
        String check = userService.login(userDTO);

        Cookie COOKIE_ID = new Cookie("id", userDTO.getId());
        COOKIE_ID.setMaxAge(COOKIE_AGE);
        response.addCookie(COOKIE_ID);

    }

    @PatchMapping("/user-status/{userStatus}")
    public void changeStatus(@CookieValue(value = "id") Cookie cookie, @PathVariable UserStatus userStatus,
                                    @RequestBody UserDTO userDTO){

        if(POSSIBLE.equals(userStatus)) {
            userService.chanageStatus(POSSIBLE, userDTO);
        }
        if(IMPOSSIBLE.equals(userStatus)){
            userService.chanageStatus(IMPOSSIBLE, userDTO);
        }
    }

}

