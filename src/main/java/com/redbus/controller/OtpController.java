//package com.redbus.controller;
//
//
//
//import com.redbus.service.OtpService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/otp")
//public class OtpController {
//
//    @Autowired
//    private OtpService otpService;
////http://localhost:8080/api/otp/send
//    @PostMapping("/send")
//    public String sendOtp(@RequestParam String email) {
//        String otp = otpService.generateOtp(email);
//        // TODO: Integrate with Email/SMS service
//        return "OTP sent to email: " + email + " [Mock OTP: " + otp + "]";
//    }
//
//    @PostMapping("/verify")
//    public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
//        boolean isValid = otpService.verifyOtp(email, otp);
//        return isValid ? "OTP verified successfully!" : "Invalid or expired OTP.";
//    }
//}
