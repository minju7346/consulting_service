package com.backend.study.handler.model;

import static org.springframework.http.HttpStatus.*;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorState {

	/* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
	INVALID_AUTH(UNAUTHORIZED, "권한이 없습니다."),
	UNAUTHORIZED_MEMBER(UNAUTHORIZED, "내 계정 정보가 존재하지 않습니다"),

	/* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
	MEMBER_NOT_FOUND(NOT_FOUND, "해당 유저 정보를 찾을 수 없습니다"),
	REFRESH_TOKEN_NOT_FOUND(NOT_FOUND, "로그아웃 된 사용자입니다"),
	WRONG_STATE(NOT_ACCEPTABLE, "처리할 수 없는 요청입니다."),

	/* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
	DUPLICATE_RESOURCE(CONFLICT, "데이터가 이미 존재합니다")

	;

	private final HttpStatus httpStatus;
	private final String detail;
}
