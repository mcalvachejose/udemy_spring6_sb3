package com.jose.springboot.error.springboot_error.models;

import java.util.Date;

public class Error {
    private String message;
    private String error;
    private Integer status;
    private Date date;

    public Error() {
    }
    
    public Error(String message, String error, Integer status, Date date) {
        this.message = message;
        this.error = error;
        this.status = status;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
