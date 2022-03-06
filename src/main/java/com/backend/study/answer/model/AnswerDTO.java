package com.backend.study.answer.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnswerDTO {
	private long id;
	@NotNull
	private long counselId;
	@NotNull
	@Size(min = 1, max = 1000)
	private String content;
	private String creatorId;
	private String modifierId;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}
