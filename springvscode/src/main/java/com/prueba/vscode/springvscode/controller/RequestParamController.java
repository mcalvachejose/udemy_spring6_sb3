package com.prueba.vscode.springvscode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.vscode.springvscode.models.dto.ParamDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Saludo por defecto", name = "mensaje") String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam Integer code ) {
        ParamDto param = new ParamDto();
        param.setCode(code);
        param.setMessage(text);
        return param;
    }
    
    @GetMapping("/requestNativa")
    public ParamDto requestNativa(HttpServletRequest request) {

        ParamDto param = new ParamDto();
        param.setCode(Integer.parseInt(request.getParameter("code")));
        param.setMessage(request.getParameter("message"));
        return param;
    }
}
