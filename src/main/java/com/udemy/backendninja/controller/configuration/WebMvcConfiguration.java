package com.udemy.backendninja.controller.configuration;

import com.udemy.backendninja.controller.component.RequestTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final RequestTimeInterceptor requestTimeInterceptor;

    @Autowired
    public WebMvcConfiguration(@Qualifier("requestTimeInterceptor") RequestTimeInterceptor requestTimeInterceptor) {
        this.requestTimeInterceptor = requestTimeInterceptor; 
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestTimeInterceptor);
    }
}
