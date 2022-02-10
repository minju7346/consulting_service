package com.backend.study.service;

import com.backend.study.dto.CategoryDTO;
import com.backend.study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired
    UserMapper userMapper;

    public List<CategoryDTO> findLowCategory(String pickCategory) {
        return userMapper.findLowCategory(pickCategory);
    }
}