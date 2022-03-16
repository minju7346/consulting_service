package com.backend.study.resolver;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.util.WebUtils;

import com.backend.study.user.mapper.UserMapper;
import com.backend.study.user.model.LoginUser;
import com.backend.study.user.model.LoginUserDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserArgumentResolver implements HandlerMethodArgumentResolver {

	private final UserMapper userMapper;

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return methodParameter.hasParameterAnnotation(LoginUser.class);
	}

	@Override
	public LoginUserDTO resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
		NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

		HttpServletRequest request = (HttpServletRequest)nativeWebRequest.getNativeRequest();
		return userMapper.selectUserById(WebUtils.getCookie(request, "id").getValue());
	}

}
