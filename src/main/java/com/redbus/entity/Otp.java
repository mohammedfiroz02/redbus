package com.redbus.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "user_otp")
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;

    private String otp;

    private LocalDateTime expiryTime;

    public Otp() {}

    public Otp(String phone, String otp, LocalDateTime expiryTime) {
        this.phone = phone;
        this.otp = otp;
        this.expiryTime = expiryTime;
    }
}
