package com.jose.curso.springboot.interceptor.springboot_s6_interceptor.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class FooController {
    
    @GetMapping("/foo")
    public Map<String, String> foo() {
        //Map<String, String> mapa = new HashMap<>();

        return Collections.singletonMap("message", "handler foo del controlador");
    }

    @GetMapping("/bar")
     public Map<String, String> bar() {
        //Map<String, String> mapa = new HashMap<>();

        return Collections.singletonMap("message", "handler bar del controlador");
    }

    @GetMapping("/baz")
     public Map<String, String> baz() {
        //Map<String, String> mapa = new HashMap<>();

        return Collections.singletonMap("message", "handler baz del controlador");
    }
}
