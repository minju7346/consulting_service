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

    @GetMapping("/category/getChild")
    public List<CategoryDTO> getChildList(@RequestParam("categoryId") long categoryId){

        return categoryService.getChildList(categoryId);
    }

    @GetMapping("/category/getAll")
    public CategoryDTO getAllCategoryTree(){

        return categoryService.getAllCategoryTree();
    }

}
