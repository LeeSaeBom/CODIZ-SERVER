package com.gachon.codiz.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.gachon.codiz.exception.ServiceExceptionHandler;

public class ServiceExceptionResolver implements HandlerExceptionResolver {

    private final ServiceExceptionHandler serviceExceptionHandler;

    public ServiceExceptionResolver(ServiceExceptionHandler serverExceptionHandler) {
        this.serviceExceptionHandler = serverExceptionHandler;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return serviceExceptionHandler.handleToModelAndView(request, response, ex);
    }
}
