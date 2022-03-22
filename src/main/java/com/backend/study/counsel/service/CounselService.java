package com.backend.study.counsel.service;

import static com.backend.study.user.model.enums.UserRole.*;
import com.backend.study.counsel.mapper.CounselMapper;
import com.backend.study.user.mapper.UserMapper;
import com.backend.study.counsel.model.CounselDTO;
import com.backend.study.user.model.enums.UserRole;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CounselService {

    private final CounselMapper counselMapper;
    private final UserMapper userMapper;

    @Transactional
    public void register(CounselDTO counselDTO) {
        if(userMapper.hasPossibleCounselor()){
            CounselDTO chargerCounselDTO = counselMapper.selectCharger(counselDTO.getCategoryId());
            counselDTO.bindChargerId(chargerCounselDTO.getChargerId());
        }
        counselMapper.insert(counselDTO);
        counselMapper.insertHistory(counselDTO.getId());
    }

    @Transactional
    public void distribute(String id, long categoryId, long counselId) {
        UserRole userRole = userMapper.selectRole(id);
        if (!(MANAGER == userRole)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "권한이 없습니다.");
        }
        CounselDTO counselDTO = counselMapper.selectCharger(categoryId);
        counselMapper.updateCharger(counselDTO.getChargerId(),counselId);
        counselMapper.insertHistory(counselId);
    }

    public int countNoChargerCounsels(String id, long categoryId){
        UserRole userRole = userMapper.selectRole(id);
        if (!(MANAGER == userRole)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "권한이 없습니다.");
        }
        return counselMapper.selectCountNoChargerCounsels(categoryId);
    }

}
