package com.backend.study.counsel.service;

import com.backend.study.counsel.mapper.CounselMapper;
import com.backend.study.counsel.model.CounselDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounselService {
    @Autowired
    private CounselMapper counselMapper;

    @Transactional
    public void register(CounselDTO counselDTO) {
        counselMapper.insert(counselDTO);
        counselMapper.insertHistory(counselDTO.getId());
    }
}
