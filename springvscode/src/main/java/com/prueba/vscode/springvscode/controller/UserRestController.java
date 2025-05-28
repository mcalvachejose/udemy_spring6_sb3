package com.prueba.vscode.springvscode.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.prueba.vscode.springvscode.models.User;
import com.prueba.vscode.springvscode.models.dto.UserDto;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object> details() {
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Titulo del Mensaje");
        model.put("name", "Raimundo");
        model.put("lastname", "Sokenza");
        return model;
    }
    
    @GetMapping("/details1")
    public Map<String, Object> details1() {
        User user = new User ("Juan", "Albarez", "pe@com");
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Titulo del Mensaje");
        model.put("user", user);
      
        return model;
    }

    @GetMapping("/details-dto")
    public UserDto detailsDto() {

        UserDto userDto = new UserDto ("Romina", new User("UserPrueba", "LastName Prueba", "pe@com"));
      
        return userDto;
    }

    @GetMapping("/list-user")
    public List<UserDto> listUser() {

        UserDto userDto = new UserDto ("Romina", new User("UserPrueba", "LastName Prueba", "pe@com"));
        UserDto userDto1 = new UserDto ("Demian", new User("UserPrueba1", "LastName Prueba1", "pe@com"));
        UserDto userDto2 = new UserDto ("Daison", new User("UserPrueba2", "LastName Prueba2", "pe@com"));
        UserDto userDto3 = new UserDto ("Dereck", new User("UserPrueba3", "LastName Prueba3", "pe@com"));
       
        List<UserDto> userList = Arrays.asList(userDto, userDto1, userDto2, userDto3);
        // List<UserDto> userList = new ArrayList<>();
        // userList.add(userDto);
        // userList.add(userDto1);
        // userList.add(userDto2);
        // userList.add(userDto3);
        return userList;
    }
}
