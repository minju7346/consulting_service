package com.backend.study.user.mapper;

import com.backend.study.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
      void registerUser(@Param("id") String id, @Param("name") String name, @Param("password") String password, @Param("role") String role, @Param("creator_id") String creator_id, @Param("modifier_id") String modifier_id);
}