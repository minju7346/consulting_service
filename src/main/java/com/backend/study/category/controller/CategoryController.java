package com.backend.study.category.controller;

import com.backend.study.category.service.CategoryService;
import com.backend.study.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Value("${db.driverClassName}")
    private String driver;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/api/findLowCategory")
    public List<CategoryDTO> findLowCategory(@RequestParam("pickParentId") long pickParentId){

        return categoryService.findLowCategory(pickParentId);
    }

    @GetMapping("/api/lookCategory")
    public List<CategoryDTO> lookCategory(){
        return categoryService.lookCategory();
    }

}
