package com.backend.study.counsel.service;



import com.backend.study.counsel.mapper.CounselMapper;
import com.backend.study.user.mapper.UserMapper;
import com.backend.study.counsel.model.CounselDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounselService {
    @Autowired
    private CounselMapper counselMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void register(CounselDTO counselDTO) {
        counselMapper.insert(counselDTO);
        counselMapper.insertHistory(counselDTO.getId());
    }

    @Transactional
    public void distribute(String id, long category_id, CounselDTO counselDTO) {
        String userRole = userMapper.selectRole(id);
        if (userRole.equals("MANAGER")){
            String user_id = counselMapper.selectCharger(category_id);
            counselMapper.updateCharger(user_id,counselDTO);
        }
    }
    
    @Transactional
    public Integer getNoChargerCounsels(String id, long category_id){
        String userRole = userMapper.selectRole(id);
        if (userRole.equals("MANAGER")) {
            return counselMapper.selectNoChargerCounsels(category_id);
        }
        return -1;
    }

}
