package com.backend.study.controller;

import com.backend.study.dto.CategoryDTO;
import com.backend.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/app/")
public class UserController{

    @Autowired
    UserService userService;

    @GetMapping("findLowCategory")
    public List<CategoryDTO>  localDate(@RequestParam("pickCategory") String pickCategory){
        List<CategoryDTO> tables = new ArrayList<>();
        tables.addAll(userService.findLowCategory(pickCategory));
        return tables;
    }

}
