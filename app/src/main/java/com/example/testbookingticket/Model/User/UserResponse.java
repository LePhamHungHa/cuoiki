package com.example.testbookingticket.Model.User;

public class UserResponse {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserResponse(String status) {
        this.status = status;
    }
}
