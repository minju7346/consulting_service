package com.backend.study.category.mapper;

import com.backend.study.category.model.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<CategoryDTO> selectChildList(long id);
    List<CategoryDTO> selectAllList();
}