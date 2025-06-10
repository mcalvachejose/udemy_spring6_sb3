package com.jose.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jose.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.jose.springboot.error.springboot_error.models.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<?> divisionByZero(Exception e) {
        Error error = new Error("Error division 0", 
                "Error", 
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                 new Date());
        //return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler({NumberFormatException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> numberFotmatEx(Exception e) {
       Map<String,String> mapa = new HashMap<>();
       mapa.put("message", "Error de formateo");
       mapa.put("error", "Error");
       mapa.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
       mapa.put("date", new Date().toString());
       return mapa;
    }

    @ExceptionHandler({NullPointerException.class, 
        HttpMessageNotWritableException.class, 
        UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> nullPointer(Exception e) {
       Map<String,String> mapa = new HashMap<>();
       mapa.put("message", e.getMessage());
       mapa.put("error", "Error null");
       mapa.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
       mapa.put("date", new Date().toString());
       return mapa;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> notFoundEx(NoHandlerFoundException e) {
        Error error = new Error("No encontrado sococio", "Mala ruta", HttpStatus.NOT_FOUND.value(), new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
        //return ResponseEntity.notFound().build();
    }

}