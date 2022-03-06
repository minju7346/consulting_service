package com.backend.study.user.controller;

import static com.backend.study.user.model.enums.UserStatus.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.backend.study.user.model.LoginUserDTO;
import com.backend.study.user.model.Permission;
import com.backend.study.user.model.UserDTO;
import com.backend.study.user.model.enums.UserRole;
import com.backend.study.user.model.enums.UserStatus;
import com.backend.study.user.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController{

    private final UserService userService;

    private final int COOKIE_AGE = 60 * 60 * 24 * 30;

    @PostMapping("/users")
    public void  register(@Valid @RequestBody UserDTO userDTO){

        userService.register(userDTO);
    }

    @PostMapping("/login")
    public void loginUser( @Valid @RequestBody LoginUserDTO loginFormDTO, HttpServletResponse response){
        userService.login(loginFormDTO);
        Cookie COOKIE_ID = new Cookie("id", loginFormDTO.getId());
        COOKIE_ID.setMaxAge(COOKIE_AGE);
        response.addCookie(COOKIE_ID);

    }

    @PatchMapping("/users/{userStatus}/status-change")
    public void changeStatus(@PathVariable UserStatus userStatus, @Valid @RequestBody UserDTO userDTO){

        if (userStatus.equals(userDTO.getStatus())) {
            throw new IllegalArgumentException("요청한 상태와 현재 상태가 같습니다.");
        }

        if(POSSIBLE.equals(userStatus)) {
            userService.chanageStatus(POSSIBLE, userDTO);
        }
        if(IMPOSSIBLE.equals(userStatus)){
            userService.chanageStatus(IMPOSSIBLE, userDTO);
        }
    }

}

