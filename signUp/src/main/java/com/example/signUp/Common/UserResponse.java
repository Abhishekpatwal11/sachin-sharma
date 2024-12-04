package com.example.signUp.Common;

public class UserResponse {
    String message;
    boolean status;
    String token;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UserResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    public UserResponse(String message, boolean status, String token) {
        this.message = message;
        this.status = status;
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
