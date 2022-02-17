package com.backend.study.counsel.mapper;

import com.backend.study.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CounselMapper {
    void registerCounsel(@Param("category_id") long category_id, @Param("title") String title, @Param("content") String content, @Param("customer_name") String customer_name, @Param("customer_email") String customer_email, @Param("creator_id") String creator_id, @Param("modifier_id") String modifier_id);
}