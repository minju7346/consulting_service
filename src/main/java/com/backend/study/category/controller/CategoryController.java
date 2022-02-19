package com.backend.study.category.controller;

import com.backend.study.category.dto.CategoryDTO;
import com.backend.study.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public CategoryDTO getAllCategoryTree(){

        return categoryService.getAllCategoryTree();
    }

    @GetMapping("/category/{id}")
    public List<CategoryDTO> getChildList(@PathVariable long id){

        return categoryService.getChildList(id);
    }
}
