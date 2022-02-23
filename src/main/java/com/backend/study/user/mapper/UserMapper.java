package com.backend.study.user.mapper;

import com.backend.study.user.model.UserDTO;
import com.backend.study.user.model.UserStatusDTO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

      String selectRole(String id);
      String selectId(UserDTO userDTO);
      void insert(UserDTO userDTO);
      void insertHistory(String id);
      void updateStatus(UserStatusDTO userStatusDTO);
      void updateStatusHistory(UserStatusDTO userStatusDTO);
}