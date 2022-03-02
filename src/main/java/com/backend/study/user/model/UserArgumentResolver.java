// package com.backend.study.user.model;
//
// import java.time.LocalDateTime;
//
// import javax.servlet.http.Cookie;
// import javax.servlet.http.HttpServletRequest;
// import javax.validation.constraints.Max;
// import javax.validation.constraints.NotNull;
//
// import org.springframework.core.MethodParameter;
// import org.springframework.stereotype.Component;
// import org.springframework.web.bind.support.WebDataBinderFactory;
// import org.springframework.web.context.request.NativeWebRequest;
// import org.springframework.web.method.support.HandlerMethodArgumentResolver;
// import org.springframework.web.method.support.ModelAndViewContainer;
// import org.springframework.web.util.WebUtils;
//
// import com.backend.study.user.model.enums.UserRole;
// import com.backend.study.user.model.enums.UserStatus;
//
// import lombok.Setter;
//
// @Component
// public class UserArgumentResolver implements HandlerMethodArgumentResolver {
// 	@Override
// 	public boolean supportsParameter(MethodParameter methodParameter) {
// 		if (methodParameter.hasParameterAnnotation(LoginUser.class)) {
// 			return true;
// 		}
// 		return false;
//
// 	}
//
// 	@Override
// 	public UserDTO resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
// 		NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
// 		HttpServletRequest request = (HttpServletRequest)nativeWebRequest.getNativeRequest();
//
// 		Cookie id = WebUtils.getCookie(request, "id");
//
// 		UserDTO userDTO.setID()
// 	}
// }
// private String id;
// 	@Max(45)
// 	private String name;
// 	@Max(45)
// 	private String password;
// 	@NotNull
// 	private UserRole role;
// 	private UserStatus status;
// 	private String useYn;
// 	private String creatorId;
// 	private String modifierId;
// 	private LocalDateTime createdAt;
// 	private LocalDateTime modifiedAt;