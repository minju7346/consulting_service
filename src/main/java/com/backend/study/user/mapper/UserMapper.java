package com.backend.study.user.mapper;

import com.backend.study.user.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

      void insert(UserDTO userDTO);
      void insertHistory(String id);
      String selectId(UserDTO userDTO);
      void updateStatusPossible(String id);
      void updateStatusPossibleHistory(String id);
      void updateStatusImpossible(String id);
      void updateStatusImpossibleHistory(String id);
}