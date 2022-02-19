package com.backend.study.counsel.service;

import com.backend.study.counsel.mapper.CounselMapper;
import com.backend.study.counsel.dto.CounselDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CounselService {
    @Autowired
    private CounselMapper counselMapper;

    public long register(CounselDTO counselDTO) {
        return counselMapper.insert(counselDTO);
    }

    public void registerHistory(long id){
        counselMapper.insertHistory(id);
    }
}
