package com.backend.study.answer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.study.answer.mapper.AnswerMapper;
import com.backend.study.answer.model.AnswerDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerService {

	private final AnswerMapper answerMapper;

	@Transactional
	public void answerCounsel(String chargerId, AnswerDTO answerDTO){
		if(!answerMapper.selectRightCharger(answerDTO.getCounselId(), chargerId)){
			throw new IllegalArgumentException("해당 문의의 담당자가 아닙니다.");
		}
		answerMapper.insertAnswer(answerDTO);
		answerMapper.insertAnswerHistory(answerDTO.getId());

	}
}
