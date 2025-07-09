package com.redbus.service;//package com.redbus.service;
//
//import com.redbus.entity.Otp;
//import com.redbus.repository.OtpRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//import java.util.Random;
//
//@Service
//public class OtpService {
//
//    private final OtpRepository otpRepository;
//    private final SmsService smsService;
//
//    private final int OTP_VALIDITY_MINUTES = 5;
//
//    @Autowired
//    public OtpService(OtpRepository otpRepository, SmsService smsService) {
//        this.otpRepository = otpRepository;
//        this.smsService = smsService;
//    }
//
//    public String generateOtp(String phone) {
//        String otp = String.format("%06d", new Random().nextInt(999999));
//        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(OTP_VALIDITY_MINUTES);
//
//        // ✅ Find existing or create new
//        Otp otpEntity = otpRepository.findByPhone(phone)
//                .orElse(new Otp(phone, otp, expiryTime));
//
//        otpEntity.setOtp(otp);
//        otpEntity.setExpiryTime(expiryTime);
//
//        otpRepository.save(otpEntity);
//
//        // ✅ Send SMS
//        String smsMessage = "Your OTP code is: " + otp + ". It will expire in 5 minutes.";
//        smsService.sendSms(phone, smsMessage);
//
//        return otp;
//    }
//
//    public boolean validateOtp(String phone, String otp) {
//        Optional<Otp> otpOptional = otpRepository.findByPhone(phone);
//
//        if (otpOptional.isEmpty()) {
//            return false;
//        }
//
//        Otp otpEntity = otpOptional.get();
//
//        boolean isOtpValid = otpEntity.getOtp().equals(otp);
//        boolean isNotExpired = LocalDateTime.now().isBefore(otpEntity.getExpiryTime());
//
//        if (isOtpValid && isNotExpired) {
//            otpRepository.delete(otpEntity); // ✅ delete OTP immediately after successful use
//            return true;
//        }
//
//        return false;
//    }
//
//}
