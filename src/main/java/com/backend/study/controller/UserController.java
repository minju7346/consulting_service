package com.backend.study.controller;

import com.backend.study.dto.CategoryDTO;
import com.backend.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;



@RestController
@RequestMapping(value = "/api/v1/app/")
public class UserController{

    @Autowired
    UserService userService;

    @GetMapping("findLowCategory")
    public List<CategoryDTO>  findLowCategory(@RequestParam("pickParentId") BigInteger pickParentId){

        return userService.findLowCategory(pickParentId);
    }

    @GetMapping("lookCategory")
    public List<CategoryDTO>  lookCategory(){

        return userService.lookCategory();
    }

    @PostMapping("registerCounsel")
    public void  registerCounsel(@RequestParam("pickCategoryId") BigInteger pickCategoryId){
        userService.registerCounsel(pickCategoryId);
    }

    @PostMapping("registerUser")
    public void  registerUser(@RequestParam("userId") String userId, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("role") String role ){
        userService.registerUser(userId, name, password,role);
    }
}
