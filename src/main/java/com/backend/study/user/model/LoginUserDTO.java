package com.backend.study.user.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginUserDTO {

	@NotNull
	@Size(min = 1, max = 25)
	private String id;
	@NotNull
	@Size(min = 1, max = 45)
	private String password;
}
