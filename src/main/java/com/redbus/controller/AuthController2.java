//package com.redbus.controller;
//
//import com.redbus.entity.User;
//import com.redbus.payload.JWTAuthResponse;
//import com.redbus.payload.LoginDto;
//import com.redbus.payload.SignUpDto;
//import com.redbus.repository.UserRepository;
//import com.redbus.security.JWTService;
//import com.redbus.service.OtpService;
//import com.redbus.service.SmsService;
//import com.redbus.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//    private final JWTService jwtService;
//    private final UserService userService;
//    @Autowired
//    private final OtpService otpService;
//    private final UserRepository userRepository;
//    private final SmsService smsService;
//
//    public AuthController(AuthenticationManager authenticationManager,
//                          JWTService jwtService,
//                          UserService userService,
//                          OtpService otpService,
//                          UserRepository userRepository, SmsService smsService) {
//        this.authenticationManager = authenticationManager;
//        this.jwtService = jwtService;
//        this.userService = userService;
//        this.otpService = otpService;
//        this.userRepository = userRepository;
//        this.smsService = smsService;
//    }
//
//    @PostMapping("/signin")
//    public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginDto.getUsername(), loginDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String token = jwtService.generateToken(authentication);
//        return ResponseEntity.ok(new JWTAuthResponse(token));
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<String> registerUser(@RequestBody SignUpDto signUpDto) {
//        try {
//            String response = userService.registerUser(signUpDto);
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        } catch (RuntimeException ex) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//        }
//    }
//
//    @PostMapping("/register-operator")
//    public ResponseEntity<String> registerOperator(@RequestBody SignUpDto signUpDto) {
//        try {
//            String response = userService.registerOperator(signUpDto);
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        } catch (RuntimeException ex) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//        }
//    }
//
//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getAllUsers() {
//        return ResponseEntity.ok(userService.getAllUsers());
//    }
//
//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable Long id) {
//        return ResponseEntity.ok(userService.getUserById(id));
//    }
//
//    @PutMapping("/users/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//        return ResponseEntity.ok(userService.updateUser(id, user));
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUsersById(@PathVariable Long id) {
//        userService.deleteUser(id);
//    }
//
//    // ✅✅✅ --- NEW: OTP-based endpoints ---
//
//    //    @PostMapping("/send-otp")
////    //http://localhost:8080/api/auth/send-otp
////    public ResponseEntity<String> sendOtp(@RequestBody LoginDto loginDto) {
////        String username = loginDto.getUsername();
////
////        // ✅ Check if user exists (by email or phone)
////        boolean userExists = userRepository.findByEmail(username).isPresent()
////                || userRepository.findByPhone(username).isPresent();
////
////        if (!userExists) {
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
////                    .body("No user found with provided email/phone");
////        }
////
////        // ✅ Generate OTP and pretend to send
////        String otp = otpService.generateOtp(username);
////        // In production: Send via SMSService or EmailService!
////        return ResponseEntity.ok("OTP sent successfully to " + otp);
////    }
//    @PostMapping("/send-otp")
//    public ResponseEntity<String> sendOtp(@RequestBody LoginDto loginDto) {
//        String username = loginDto.getUsername();
//
//        Optional<User> optionalUser = userRepository.findByEmail(username);
//        if (optionalUser.isEmpty()) {
//            optionalUser = userRepository.findByPhone(username);
//        }
//
//        if (optionalUser.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("No user found with provided email/phone");
//        }
//
//        User user = optionalUser.get();
//        String phoneNumber = user.getPhone(); // Make sure phone field exists!
//
//        String otp = otpService.generateOtp(username);
//
//        // ✅ Send OTP via SMS
//        smsService.sendOtpSms(phoneNumber, otp);
//
//        return ResponseEntity.ok("OTP sent successfully to your registered phone number");
//    }
//
//
//    @PostMapping("/verify-otp")
//    //http://localhost:8080/api/auth/verify-otp
//    public ResponseEntity<?> verifyOtp(@RequestBody LoginDto loginDto) {
//        String username = loginDto.getUsername();
//        String otp = loginDto.getOtp();
//
//        boolean isValid = otpService.verifyOtp(username, otp);
//
//        if (!isValid) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired OTP");
//        }
//
//        // ✅ Check user exists
//        User user = userRepository.findByEmail(username)
//                .or(() -> userRepository.findByPhone(username))
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        // ✅ Generate JWT token for this user
//        Authentication auth =
//                new UsernamePasswordAuthenticationToken(user.getUsername(), null, null);
//        String token = jwtService.generateToken(auth);
//
//        return ResponseEntity.ok(new JWTAuthResponse(token));
//    }
//}
