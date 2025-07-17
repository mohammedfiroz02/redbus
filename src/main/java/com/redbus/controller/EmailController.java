package com.redbus.controller;//package com.redbus.controller;
//
//import com.redbus.service.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("/sending")
//public class EmailController {
//
//   @Autowired
//   EmailService emailService;
//
//    @PostMapping("/send-email")
//    public ResponseEntity<String> sendEmail(
//            @RequestParam String to,
//            @RequestParam String subject,
//            @RequestParam String message
//    ) {
//        emailService.sendEmail(to, subject, message);
//        return ResponseEntity.ok("Email sent successfully");
//    }
//
//}
