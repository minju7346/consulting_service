package com.backend.study.configuration;

import org.springframework.context.annotation.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@Import({MyBatisConfig.class})
@PropertySource("classpath:application.properties")
@EnableWebMvc
@ComponentScan({
        "com.backend.study.**.controller",
        "com.backend.study.**.service"
})
public class AppConfig implements WebMvcConfigurer {

    // Interceptor
    // argumentResolver 등 넣어줌
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
    }
}