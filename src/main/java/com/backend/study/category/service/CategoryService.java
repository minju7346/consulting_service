package com.backend.study.category.service;

import com.backend.study.category.mapper.CategoryMapper;
import com.backend.study.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    public List<CategoryDTO> findLowCategory(long pickParentId) {
        return categoryMapper.findLowCategory(pickParentId);
    }

    public List<CategoryDTO> lookCategory() {
        return categoryMapper.lookCategory();
    }

}