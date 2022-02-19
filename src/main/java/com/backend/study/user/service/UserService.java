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

    @Transactional
    public void register(UserDTO userDTO) {
        userMapper.insert(userDTO);
        userMapper.insertHistory(userDTO.getId());
    }

    public String login(UserDTO userDTO) {
        return userMapper.selectId(userDTO);
    }

    @Transactional
    public void toPossible(String id){
        userMapper.updateStatusPossible(id);
        userMapper.updateStatusPossibleHistory(id);
    }

    @Transactional
    public void toImpossible(String id){
        userMapper.updateStatusImpossible(id);
        userMapper.updateStatusImpossibleHistory(id);
    }

}