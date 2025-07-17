package com.redbus;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AdminPassword {

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String rawPassword = "admin";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println("Raw Admin Password: " + rawPassword);
        System.out.println("Encoded Admin Password: " + encodedPassword);
    }
}
