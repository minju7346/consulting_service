package com.backend.study.category.mapper;

import com.backend.study.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {
    List<CategoryDTO> findLowCategory(long pickParentId);
    List<CategoryDTO> lookCategory();
}