package com.backend.study.configuration;

import org.springframework.context.annotation.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import com.backend.study.interceptor.AuthManagerInterceptor;
import com.backend.study.resolver.UserArgumentResolver;
import com.backend.study.interceptor.AuthLoginInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@Import({MyBatisConfig.class})
@PropertySource("classpath:application.properties")
@EnableWebMvc
@ComponentScan({"com.backend.study"})

@RequiredArgsConstructor
@Component
public class AppConfig implements WebMvcConfigurer {

    private final AuthLoginInterceptor authLoginInterceptor;
    private final AuthManagerInterceptor authManagerInterceptor;
    private final UserArgumentResolver userArgumentResolver;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authLoginInterceptor)
            .addPathPatterns("/users/**", "/answer");
        registry.addInterceptor(authManagerInterceptor)
            .addPathPatterns("/counsels/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(userArgumentResolver);
    }
}
