package com.prueba.vscode.springvscode.models.dto;

public class ParamDto {

    private String message;
    private Integer code;

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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    
}
