package com.backend.study.handler.model;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;

import com.backend.study.handler.model.ErrorState;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
	private final LocalDateTime timestamp = LocalDateTime.now();
	private final int status;
	private final String error;
	private final String code;
	private final String message;

	public static ResponseEntity<ErrorResponse> toResponseEntity(ErrorState errorState) {
		return ResponseEntity
			.status(errorState.getHttpStatus())
			.body(ErrorResponse.builder()
				.status(errorState.getHttpStatus().value())
				.error(errorState.getHttpStatus().name())
				.code(errorState.name())
				.message(errorState.getDetail())
				.build()
			);
	}
}