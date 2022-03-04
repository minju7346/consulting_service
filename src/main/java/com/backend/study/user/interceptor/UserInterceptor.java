package com.backend.study.user.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import com.backend.study.user.mapper.UserMapper;
import com.backend.study.user.model.Permission;
import com.backend.study.user.model.enums.UserRole;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserInterceptor implements HandlerInterceptor {

	private final UserMapper userMapper;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		HandlerMethod method = (HandlerMethod)handler;
		Permission permission = method.getMethodAnnotation(Permission.class);
		if(permission == null) {
			return true;
		}

		String cookie = WebUtils.getCookie(request, "id").getValue();
		UserRole userRole = userMapper.selectRole(cookie);

		if(permission.authority().equals(UserRole.MANAGER)){
			if(userRole.equals(UserRole.MANAGER)){
				return true;
			}
		}

		if(permission.authority().equals(UserRole.COUNSELOR)){
			if(userRole.equals(UserRole.COUNSELOR)){
				return true;
			}
		}
		throw new RuntimeException("No access");
	}
}