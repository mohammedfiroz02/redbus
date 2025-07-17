package com.redbus;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class OperatorPasswordGenerator {

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String rawPassword = "operator1";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        String role = "ROLE_OPERATOR";

        System.out.println("=== OPERATOR USER ===");
        System.out.println("Raw Password     : " + rawPassword);
        System.out.println("Encoded Password : " + encodedPassword);
        System.out.println("Role             : " + role);
    }
}
