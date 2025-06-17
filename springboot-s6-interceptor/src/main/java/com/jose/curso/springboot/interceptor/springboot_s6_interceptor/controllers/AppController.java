package com.jose.curso.springboot.interceptor.springboot_s6_interceptor.controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/horario")
public class AppController {

    @GetMapping("/foo")
    public ResponseEntity<?> foo(HttpServletRequest request) {
        
        Map<String, Object> map  = new HashMap<>();
        map.put("title", "Bien venido");
        map.put("time", new Date());
        map.put("message", request.getAttribute("message"));

        return ResponseEntity.ok(map);
    }
}