package com.backend.study.counsel.mapper;

import com.backend.study.counsel.model.AnswerDTO;
import com.backend.study.counsel.model.CounselDTO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CounselMapper {
    void insert(CounselDTO counselDTO);
    void insertHistory(long id);
    CounselDTO selectCharger(long categoryId);
    void updateCharger(@Param("userId") String userId, @Param("id") long id);
    int selectCountNoChargerCounsels(long categoryId);
    boolean isRightCharger(@Param("counselId") long counselId, @Param("chargerId")String chargerId);
    void insertAnswer(AnswerDTO answerDTO);
    void insertAnswerHistory(long answerId);
}