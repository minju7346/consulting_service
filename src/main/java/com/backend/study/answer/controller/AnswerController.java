package com.backend.study.answer.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.study.answer.service.AnswerService;
import com.backend.study.answer.model.AnswerDTO;
import com.backend.study.user.model.LoginUser;
import com.backend.study.user.model.LoginUserDTO;
import com.backend.study.user.model.Permission;
import com.backend.study.user.model.enums.UserRole;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AnswerController {

	private final AnswerService answerService;

	@PostMapping("/answers")
	public void answerCounsel(@LoginUser LoginUserDTO loginUserDTO,
		@Valid @RequestBody AnswerDTO answerDTO){

		answerService.answerCounsel(loginUserDTO.getId(), answerDTO);
	}

}
