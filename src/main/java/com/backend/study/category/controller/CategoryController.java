package com.backend.study.category.controller;

import com.backend.study.category.model.CategoryDTO;
import com.backend.study.category.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public CategoryDTO getAllCategoryTree(){

        return categoryService.getAllCategoryTree();
    }

    @GetMapping("/categories/{id}/children")
    public List<CategoryDTO> getChildList(@PathVariable long id){

        return categoryService.getChildList(id);
    }
}
