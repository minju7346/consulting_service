package com.backend.study.user.service;

import com.backend.study.user.model.UserDTO;
import com.backend.study.user.mapper.UserMapper;
import com.backend.study.user.model.enums.UserStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserMapper userMapper;

    @Transactional
    public void register(UserDTO userDTO) {
        userMapper.insert(userDTO);
        userMapper.insertHistory(userDTO.getId());
    }


    public String login(UserDTO userDTO) {
        if (!userMapper.selectExistId(userDTO.getId())) {
            throw new IllegalArgumentException("아이디가 존재하지 않습니다.");
        }
        if (!userMapper.selectIdByPassword(userDTO)) {
            throw new IllegalArgumentException("비밀번호가 맞지 않습니다.");
        }
        return userDTO.getId();
    }

    @Transactional
    public void chanageStatus(UserStatus userStatus, UserDTO userDTO){
        if (userStatus.equals(userDTO.getStatus())) {
            throw new IllegalArgumentException("요청한 상태와 현재 상태가 같습니다.");
        }
        userMapper.updateStatus(userStatus, userDTO.getId());
        userMapper.insertHistory(userDTO.getId());
    }

}