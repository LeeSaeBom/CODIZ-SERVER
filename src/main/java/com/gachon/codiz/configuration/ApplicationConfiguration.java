package com.gachon.codiz.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.gachon.codiz.exception.ServiceExceptionHandler;
import com.gachon.codiz.servlet.ServiceExceptionResolver;

@Configuration
public class ApplicationConfiguration implements WebMvcConfigurer {

    @Autowired
    private ServiceExceptionResolver serviceExceptionResolver;

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(serviceExceptionResolver);
    }

    @Bean
    public ServiceExceptionResolver serviceExceptionResolver(ServiceExceptionHandler serviceExceptionHandler) {
        return new ServiceExceptionResolver(serviceExceptionHandler);
    }

    @Bean
    public ServiceExceptionHandler serviceExceptionHandler() {
        return new ServiceExceptionHandler();
    }

    @Bean
    public RequestMappingHandlerAdapter handlerAdapter() {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setMessageConverters(List.of(new MappingJackson2HttpMessageConverter()));
        return requestMappingHandlerAdapter;
    }
}
