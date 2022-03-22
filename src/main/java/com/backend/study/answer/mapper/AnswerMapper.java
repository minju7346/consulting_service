package com.backend.study.answer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.backend.study.answer.model.AnswerDTO;

@Mapper
public interface AnswerMapper {

	boolean selectRightCharger(@Param("counselId") long counselId, @Param("chargerId")String chargerId);
	void insertAnswer(AnswerDTO answerDTO);
	void insertAnswerHistory(long answerId);
}
