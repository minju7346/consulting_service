package com.backend.study.user.mapper;

import com.backend.study.user.model.LoginUserDTO;
import com.backend.study.user.model.UserDTO;
import com.backend.study.user.model.enums.UserRole;
import com.backend.study.user.model.enums.UserStatus;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

      boolean hasPossibleCounselor();
      UserRole selectRole(String id);
      LoginUserDTO selectUserById(String id);
      Boolean selectExistUser(String id);
      void insert(UserDTO userDTO);
      void insertHistory(String id);
      void updateStatus(@Param("userStatus") UserStatus userStatus,@Param("id") String id);
}