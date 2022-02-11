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
    public void  registerCounsel(@RequestParam("category_id") BigInteger category_id, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("customer_name") String customer_name,@RequestParam("customer_email") String customer_email, @RequestParam("creator_id") String creator_id, @RequestParam("modifier_id") String modifier_id){
        userService.registerCounsel(category_id, title, content, customer_name, customer_email, creator_id, modifier_id);
    }

    @PostMapping("registerUser")
    public void  registerUser(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("role") String role, @RequestParam("creator_id") String creator_id, @RequestParam("modifier_id") String modifier_id ){
        userService.registerUser(id, name, password, role, creator_id, modifier_id);
    }
}
