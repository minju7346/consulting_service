package com.backend.study.user.service;

import com.backend.study.user.model.LoginUserDTO;
import com.backend.study.user.model.UserDTO;
import com.backend.study.user.mapper.UserMapper;
import com.backend.study.user.model.enums.UserStatus;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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


    public String login(LoginUserDTO loginUserDTO) {
        LoginUserDTO loginUser = userMapper.selectUserById(loginUserDTO.getId());
        if (loginUser.getId() != loginUserDTO.getId()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "아이디가 존재하지 않습니다.");
        }
        if (loginUser.getPassword() != loginUserDTO.getPassword()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "맞는 비밀번호가 존재하지 않습니다.");
        }
        return loginUserDTO.getId();
    }

    @Transactional
    public void chanageStatus(UserStatus userStatus, UserDTO userDTO){
        userMapper.updateStatus(userStatus, userDTO.getId());
        userMapper.insertHistory(userDTO.getId());
    }

}