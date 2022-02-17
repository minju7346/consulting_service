package com.backend.study.user.controller;

import com.backend.study.dto.CategoryDTO;
import com.backend.study.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{
    @Value("${db.driverClassName}")
    private String driver;

    @Autowired
    private UserService userService;

    @PostMapping("/api/registerUser")
    public void  registerUser(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("role") String role, @RequestParam("creator_id") String creator_id, @RequestParam("modifier_id") String modifier_id ){
        userService.registerUser(id, name, password, role, creator_id, modifier_id);
    }
}
