package com.redbus.service;//package  com.redbus.service;
//import org.springframework.stereotype.Service;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Random;
//
//@Service
//public class OtpService {
//
//    private final Map<String, String> otpStorage = new HashMap<>();
//    private final Random random = new Random();
//
//    // Generate a 6-digit OTP and store it
//    public String generateOtp(String username) {
//        String otp = String.format("%06d", random.nextInt(999999));
//        otpStorage.put(username, otp);
//        // TODO: Actually send OTP via SMS or Email here
//        System.out.println("Generated OTP for " + username + " is: " + otp);
//        otpStorage.clear();
//        return otp;
//    }
//
//    // Verify OTP
//    public boolean verifyOtp(String username, String otp) {
//        String storedOtp = otpStorage.get(username);
//        if (storedOtp != null && storedOtp.equals(otp)) {
//            otpStorage.remove(username); // remove after successful verification
//            return true;
//        }
//        return false;
//    }
//}
