package com.backend.study.user.service;

import com.backend.study.dto.CategoryDTO;
import com.backend.study.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{

    @Autowired
    UserMapper userMapper;

    public void registerUser(String id, String name, String password, String role, String creator_id, String modifier_id) {
        userMapper.registerUser(id, name, password, role, creator_id, modifier_id);
    }
}
