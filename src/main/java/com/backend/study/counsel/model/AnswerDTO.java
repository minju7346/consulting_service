package com.backend.study.counsel.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class AnswerDTO {

	private long id;
	@NotNull
	private long counselId;
	private String content;
	private String creatorId;
	private String modifierId;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
}
