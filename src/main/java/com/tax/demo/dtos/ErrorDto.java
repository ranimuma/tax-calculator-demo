package com.tax.demo.dtos;

import java.util.Map;

import lombok.Data;


public class ErrorDto {
    private String message;
    private String details;

    // Constructors, getters, and setters
    
    public ErrorDto(String message, String details) {
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
