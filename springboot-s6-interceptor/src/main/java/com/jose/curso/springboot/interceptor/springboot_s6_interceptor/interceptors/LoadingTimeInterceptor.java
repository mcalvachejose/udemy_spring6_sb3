package com.jose.curso.springboot.interceptor.springboot_s6_interceptor.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor{

    private static final Logger log = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        HandlerMethod controller = (HandlerMethod)handler;
        log.info("LoadingTimeInterceptor : postHandle() saliendo...." + controller.getMethod().getName());
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                log.info("LoadingTimeInterceptor : preHandle() entrado...." + ((HandlerMethod)handler).getMethod().getName());
        return true;
    }
    
}
