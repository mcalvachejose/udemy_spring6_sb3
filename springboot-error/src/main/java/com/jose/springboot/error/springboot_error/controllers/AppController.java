package com.jose.springboot.error.springboot_error.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.jose.springboot.error.springboot_error.models.User;
import com.jose.springboot.error.springboot_error.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String index(){
        //int a = 200/0;
        int a = Integer.parseInt("na");
        System.out.println(a);
        return "OK 200";
    }

    @GetMapping("/{id}")
    public User find(@PathVariable Long id) {
        User user = userService.find(id);
        if (user == null)
        throw new UserNotFoundException("Usuario no existe");
        System.out.println(user.getLastname());
        return user;
    }

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }
}
