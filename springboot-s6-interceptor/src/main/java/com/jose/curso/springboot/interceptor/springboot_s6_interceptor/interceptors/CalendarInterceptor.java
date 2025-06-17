package com.jose.curso.springboot.interceptor.springboot_s6_interceptor.interceptors;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("calendarInterceptor")
public class CalendarInterceptor implements HandlerInterceptor{

    @Value("${config.calendar.open}")
    private Integer open;
   
    @Value("${config.calendar.close}")
    private Integer close;

     private static final Logger log = LoggerFactory.getLogger(CalendarInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR);

        log.info("hora: " + hour + " open-cloase: " + open + "-" +close);

        if (hour>=open && hour<=close) {
            StringBuilder message = new StringBuilder("Bien venidos en horario atencion al cliente");
            message.append("atendemos desde las ");
            message.append(open + " ");
            message.append("hasta la hora de cierre ");
            message.append(close + " ");
            message.append("Gracias por su visita");
            request.setAttribute("message", message.toString());
            return true;
        }

        Map<String,String> mapOutTime = new HashMap<>();
        mapOutTime.put("error", "Fuera de horario");
        mapOutTime.put("time", LocalTime.now().toString());

        ObjectMapper mapper = new ObjectMapper();

        response.setStatus(401);
        response.setContentType("application/json");
        response.getWriter().write(mapper.writeValueAsString(mapOutTime));
        
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
    }
}
