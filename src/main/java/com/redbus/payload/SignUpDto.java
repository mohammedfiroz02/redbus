package com.redbus.payload;

import lombok.Data;

@Data
public class SignUpDto {
    private String username;
    private String email;
    private String password;
    private String role; // Optional: if you want to choose between USER/OPERATOR
}
