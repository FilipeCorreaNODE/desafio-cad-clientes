package com.desafio.config;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.RequestContextFilter;

import jakarta.faces.webapp.FacesServlet;

@Configuration
public class WebConfig implements ServletContextInitializer {

    @Override
    public void onStartup(jakarta.servlet.ServletContext servletContext) {

    }

    @Bean
    public ServletRegistrationBean<FacesServlet> facesServletRegistrationBean() {
        ServletRegistrationBean<FacesServlet> registrationBean = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public RequestContextFilter requestContextFilter() {
        return new RequestContextFilter();
    }
}
