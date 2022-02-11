package com.backend.study.mapper;

import com.backend.study.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<CategoryDTO>  findLowCategory(BigInteger pickParentId);
    List<CategoryDTO> lookCategory();
    void registerCounsel(BigInteger pickCategoryId);
    void registerUser(@Param("userId") String userId, @Param("name") String name, @Param("password") String password, @Param("role") String role);
    void registerCounselor(@Param("userId") String userId);
}