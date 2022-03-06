package com.backend.study.handler;

import static com.backend.study.handler.model.ErrorState.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.backend.study.handler.model.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<ErrorResponse> responseStatusExceptionHandler(ResponseStatusException e) {
		log.error("stateExceptionHandler throw Exception : {}", UNAUTHORIZED_MEMBER);
		return ErrorResponse.toResponseEntity(UNAUTHORIZED_MEMBER);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> illegalArgumentExceptionHandler(IllegalArgumentException e) {
		log.error("handleDataException throw Exception : {}", WRONG_STATE);
		return ErrorResponse.toResponseEntity(WRONG_STATE);
	}


}

