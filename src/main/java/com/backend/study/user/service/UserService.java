package com.backend.study.user.service;

import com.backend.study.user.dto.UserDTO;
import com.backend.study.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService{

    @Autowired
    UserMapper userMapper;

    public void register(UserDTO userDTO) {
        userMapper.insert(userDTO);
    }

    public void registerHistory(String id) {
        userMapper.insertHistory(id);
    }
}
