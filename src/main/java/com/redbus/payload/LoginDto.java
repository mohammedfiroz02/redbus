package com.redbus.payload;

import lombok.Data;

@Data
public class LoginDto {
    private String username;

    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
