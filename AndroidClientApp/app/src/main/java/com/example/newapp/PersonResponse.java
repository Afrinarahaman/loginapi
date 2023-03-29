package com.example.newapp;

public class PersonResponse {
    String message;
    Boolean status;

    public PersonResponse() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PersonResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
}
