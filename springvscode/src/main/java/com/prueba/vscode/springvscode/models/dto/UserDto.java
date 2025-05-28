package com.prueba.vscode.springvscode.models.dto;

import com.prueba.vscode.springvscode.models.User;

public class UserDto {

    private String name;
    private User user;

    public UserDto(String name, User user) {
        this.name = name;
        this.user = user;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public User getUser() {
        return user;
    }
    public void setLastName(User user) {
        this.user = user;
    }
}
