package com.backend.study.controller;

import com.backend.study.dto.CategoryDTO;
import com.backend.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/app/")
public class UserController{

    @Autowired
    UserService userService;

    @GetMapping("findLowCategory")
    public List<CategoryDTO>  localDate(@RequestParam("pickParentId") BigInteger pickParentId){

        List<CategoryDTO> tables = new ArrayList<>();
        tables.addAll(userService.findLowCategory(pickParentId));
        return tables;
    }

    @GetMapping("lookCategory")
    public List<CategoryDTO>  localDate(){

        List<CategoryDTO> tables = new ArrayList<>();
        tables.addAll(userService.lookCategory());
        return tables;
    }
}
