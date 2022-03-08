package com.backend.study.user.model;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginUserDTO {

	@NotNull
	@Length(min = 1, max = 25)
	private String id;
	@NotNull
	@Length(min = 1, max = 45)
	private String password;
}
