package com.backend.study.user.mapper;

import com.backend.study.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
      void insertUser(UserDTO userDTO);
      void insertUserHistory(UserDTO userDTO);
      String selectId(UserDTO userDTO);
}