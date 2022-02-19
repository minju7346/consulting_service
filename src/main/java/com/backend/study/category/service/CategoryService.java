package com.backend.study.category.service;

import com.backend.study.category.dto.CategoryDTO;
import com.backend.study.category.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryDTO getAllCategoryTree() {
        Map<Long, CategoryDTO> categoryMap = categoryMapper.selectAllList()
                .stream()
                .collect(Collectors.toMap(CategoryDTO::getId, Function.identity()));
        return makeTree(categoryMap);
    }

    private CategoryDTO makeTree(Map<Long, CategoryDTO> categoryMap) {
        categoryMap.values().stream()
                .filter((CategoryDTO) -> !Objects.isNull(CategoryDTO.getParentId()))
                .forEach((CategoryDTO) -> {
                    CategoryDTO parentCategory = categoryMap.get(CategoryDTO.getParentId());
                    parentCategory.addChild(CategoryDTO);
                });

        return findRootCategory(categoryMap);
    }

    private CategoryDTO findRootCategory(Map<Long, CategoryDTO> categoryMap) {
        return categoryMap.values().stream()
                .filter(CategoryDTO -> Objects.isNull(CategoryDTO.getParentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Category Tree has no root"));
    }


    public List<CategoryDTO> getChildList(long id) {

        return categoryMapper.selectChildList(id);
    }
}
