package com.services.messageService.dtos;

public class UserDTO {
    private String email;
    private String password;

    public UserDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
