package com.backend.study.service;

import com.backend.study.dto.CategoryDTO;
import com.backend.study.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserService{

    @Autowired
    UserMapper userMapper;

    public List<CategoryDTO> findLowCategory(BigInteger pickParentId) {
        return userMapper.findLowCategory(pickParentId);
    }

    public List<CategoryDTO> lookCategory() {
        return userMapper.lookCategory();
    }

    public void registerCounsel(BigInteger category_id, String title,String content, String customer_name, String customer_email, String creator_id, String modifier_id) {
        userMapper.registerCounsel(category_id, title, content, customer_name, customer_email, creator_id, modifier_id);
    }

    public void registerUser(String id, String name, String password, String role, String creator_id, String modifier_id) {
        userMapper.registerUser(id, name, password, role, creator_id, modifier_id);
        if(role == "" || role.equals("COUNSELOR")){
            userMapper.registerCounselor(id, creator_id);
        }
    }
}