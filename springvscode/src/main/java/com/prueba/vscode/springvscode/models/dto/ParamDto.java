package com.prueba.vscode.springvscode.models.dto;

public class ParamDto {

    private String message;

    public ParamDto(String message) {
        this.message = message;
    }

    public ParamDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
}
