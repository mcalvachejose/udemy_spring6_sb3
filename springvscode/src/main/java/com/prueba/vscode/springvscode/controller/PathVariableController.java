package com.prueba.vscode.springvscode.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.vscode.springvscode.models.User;
import com.prueba.vscode.springvscode.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

 //   @Value("${config.message}")
 //   private String message;

    @Value("${config.listOfValues}")
    private String[] listOfValues;

    @Value("${config.code}")
    private String code;

    @Value("${prueba.palabra}")
    private String prueba;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable(name="message") String messageOtro) {
        ParamDto param = new ParamDto();
        param.setMessage(messageOtro);
        return param;
    }

    @GetMapping("/mix/{code}/{id}/{message}")
    public Map mix (@PathVariable() Integer code, @PathVariable Long id, @PathVariable String message) {

        Map<String, Object> json = new HashMap();
        json.put("code", code);
        json.put("id", id);
        json.put("message", message);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        return user;
    }
    
    @GetMapping("/values")
    public Map<String,Object> values(@Value("${config.message}") String message) {
        Map<String, Object> values = new HashMap<>();
        values.put("username", username);
        values.put("message", message);
        values.put("code", code);
        values.put("listOfValues", listOfValues);
        values.put("prueba", prueba);
        return values;
    }
}
