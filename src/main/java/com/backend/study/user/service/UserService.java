package com.backend.study.user.service;

import com.backend.study.user.model.UserDTO;
import com.backend.study.user.mapper.UserMapper;
import com.backend.study.user.model.UserStatusDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService{

    @Autowired
    UserMapper userMapper;

    @Transactional
    public void register(UserDTO userDTO) {
        userMapper.insert(userDTO);
        userMapper.insertHistory(userDTO.getId());
    }

    public String login(UserDTO userDTO) {

        return userMapper.selectId(userDTO);
    }

    @Transactional
    public void chanageStatus(UserStatusDTO userStatusDTO){
        userMapper.updateStatus(userStatusDTO);
        userMapper.updateStatusHistory(userStatusDTO);
    }

}