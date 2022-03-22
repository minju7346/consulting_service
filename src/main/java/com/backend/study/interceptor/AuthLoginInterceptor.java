package com.backend.study.interceptor;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import com.backend.study.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class AuthLoginInterceptor implements HandlerInterceptor {

	private final UserMapper userMapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		HandlerMethod method = (HandlerMethod)handler;

		String userId = WebUtils.getCookie(request, "id").getValue();
		if (userId == null) {
			throw new NoSuchElementException(HttpStatus.UNAUTHORIZED + "쿠키가 존재하지 않습니다.");
		}

		if (!userMapper.selectExistUser(userId)) {
			throw new IllegalStateException("로그인이 필요합니다.");
		}
		return true;
	}
}