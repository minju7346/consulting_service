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
    void registerCounsel(@Param("category_id") BigInteger category_id, @Param("title") String title, @Param("content") String content, @Param("customer_name") String customer_name, @Param("customer_email") String customer_email, @Param("creator_id") String creator_id, @Param("modifier_id") String modifier_id);
    void registerUser(@Param("id") String id, @Param("name") String name, @Param("password") String password, @Param("role") String role, @Param("creator_id") String creator_id, @Param("modifier_id") String modifier_id);
    void registerCounselor(@Param("id") String userId, @Param("creator_id") String creator_id);
}