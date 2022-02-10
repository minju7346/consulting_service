package com.backend.study.mapper;

import com.backend.study.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<CategoryDTO>  findLowCategory(String pickCategory);
}
