package com.practice.EcomProductService.dto;
import org.springframework.http.HttpStatus;

public class ErrorResponseDTO {
    private String message;
    private int messageCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }
}
