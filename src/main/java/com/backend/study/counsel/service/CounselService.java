package com.backend.study.counsel.service;

import static com.backend.study.user.model.enums.UserRole.*;
import static com.backend.study.user.model.enums.UserStatus.*;

import com.backend.study.counsel.mapper.CounselMapper;
import com.backend.study.counsel.model.AnswerDTO;
import com.backend.study.user.mapper.UserMapper;
import com.backend.study.counsel.model.CounselDTO;
import com.backend.study.user.model.enums.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CounselService {

    private final CounselMapper counselMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void register(CounselDTO counselDTO) {
        if(userMapper.hasPossibleCounselor()){
            CounselDTO chargerCounselDTO = counselMapper.selectCharger(counselDTO.getCategoryId());
            counselDTO.setChargerId(chargerCounselDTO.getChargerId());
        }
        counselMapper.insert(counselDTO);
        counselMapper.insertHistory(counselDTO.getId());
    }

    @Transactional
    public void distribute(String id, long categoryId, long counselId) {
        UserRole userRole = userMapper.selectRole(id);
        if (!(MANAGER == userRole)) {
            throw new IllegalStateException("권한이 없습니다.");
        }
        CounselDTO counselDTO = counselMapper.selectCharger(categoryId);
        counselMapper.updateCharger(counselDTO.getChargerId(),counselId);
        counselMapper.insertHistory(counselId);
    }

    public int countNoChargerCounsels(String id, long categoryId){
        UserRole userRole = userMapper.selectRole(id);
        if (!(MANAGER == userRole)) {
            throw new IllegalStateException("권한이 없습니다.");
        }
        return counselMapper.selectCountNoChargerCounsels(categoryId);
    }

    public void answerCounsel(String chargerId, AnswerDTO answerDTO){
        if(!counselMapper.isRightCharger(answerDTO.getCounselId(), chargerId)){
            throw new IllegalArgumentException("해당 문의의 담당자가 아닙니다.");
        }
        counselMapper.insertAnswer(answerDTO);
        counselMapper.insertAnswerHistory(answerDTO.getId());

    }

}
