package com.backend.study.counsel.service;

import com.backend.study.dto.CategoryDTO;
import com.backend.study.counsel.mapper.CounselMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounselService {
    @Autowired
    private CounselMapper counselMapper;

    public void registerCounsel(long category_id, String title,String content, String customer_name, String customer_email, String creator_id, String modifier_id) {
        counselMapper.registerCounsel(category_id, title, content, customer_name, customer_email, creator_id, modifier_id);
    }
}
