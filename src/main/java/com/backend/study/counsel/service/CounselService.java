package com.backend.study.counsel.service;

import com.backend.study.counsel.mapper.CounselMapper;
import com.backend.study.counsel.dto.CounselDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CounselService {
    @Autowired
    private CounselMapper counselMapper;

    @Transactional
    public void registerCounsel(CounselDTO counselDTO) {
        counselMapper.insertCounsel(counselDTO);
        this.registerCounselHistory(counselDTO);
    }

    @Transactional
    public void registerCounselHistory(CounselDTO counselDTO){
        counselMapper.insertCounselHistory(counselDTO);
    }
}
