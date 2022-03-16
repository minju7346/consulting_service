package com.backend.study;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.backend.study.configuration.AppConfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@EnableScheduling
public class Application implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        addListener(rootContext);

        addServlet(servletContext, rootContext);

        addFilter(servletContext);
    }

    private void addListener(AnnotationConfigWebApplicationContext rootContext) {}

    private void addServlet(ServletContext servletContext, AnnotationConfigWebApplicationContext rootContext) {
        // root contetxt 와 servlet context 의 개념 알기
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    private void addFilter(ServletContext servletContext) {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true, true);
        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter(
                "characterEncodingFilter", characterEncodingFilter);
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
