package com.backend.study.user.model;

import com.backend.study.user.model.enums.UserStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserStatusDTO {
	private String id;
	private UserStatus status;
}
