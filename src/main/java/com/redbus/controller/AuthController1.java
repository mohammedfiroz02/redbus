//package com.redbus.controller;
//
//import com.redbus.entity.User;
//import com.redbus.payload.JWTAuthResponse;
//import com.redbus.payload.LoginDto;
//import com.redbus.payload.SignUpDto;
//import com.redbus.security.JWTService;
//import com.redbus.service.UserService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//public class AuthController1 {
//    package com.redbus.controller;
//import com.redbus.entity.User;
////import com.redbus.payload.JWTAuthResponse;
//import com.redbus.payload.JWTAuthResponse;
//import com.redbus.payload.LoginDto;
//import com.redbus.payload.SignUpDto;
//import com.redbus.security.JWTService;
//import com.redbus.service.UserService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//    @RestController
//    @RequestMapping("/api/auth")
//    public class AuthController {
//
//        private final AuthenticationManager authenticationManager;
//
//        private final JWTService jwtService;
//        private final UserService userService;
//
//        public AuthController(AuthenticationManager authenticationManager, JWTService jwtService, UserService userService) {
//            this.authenticationManager = authenticationManager;
//            this.jwtService=jwtService;
//            this.userService = userService;
//        }
//
//        @PostMapping("/signin")
//        public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto) {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            loginDto.getUsername(), loginDto.getPassword()));
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            String token = jwtService.generateToken(authentication);
//            return ResponseEntity.ok(new JWTAuthResponse(token));
//        }
//
//        @PostMapping("/signup")
//        //https://localhost:8080/api/auth/signup
//        public ResponseEntity<String> registerUser(@RequestBody SignUpDto signUpDto) {
//            try {
//                String response = userService.registerUser(signUpDto);
//                return ResponseEntity.status(HttpStatus.CREATED).body(response);
//            } catch (RuntimeException ex) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//            }
//        }
//
//        @PostMapping("/register-operator")
//        //http://localhost:8080/api/auth/register-operator
//        public ResponseEntity<String> registerOperator(@RequestBody SignUpDto signUpDto) {
//            try {
//                String response = userService.registerOperator(signUpDto);
//                return ResponseEntity.status(HttpStatus.CREATED).body(response);
//            } catch (RuntimeException ex) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
//            }
//
//        }
//        @GetMapping("/users")
//        public ResponseEntity<List<User>> getAllUsers() {
//            return ResponseEntity.ok(userService.getAllUsers());
//        }
//
//        @GetMapping("/users/{id}")
//        public ResponseEntity<User> getUserById(@PathVariable Long id) {
//            return ResponseEntity.ok(userService.getUserById(id));
//        }
//
//        @PutMapping("/users/{id}")
//        public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//            return ResponseEntity.ok(userService.updateUser(id, user));
//        }
//        @DeleteMapping("/users/{id}")
//        public void deleteUsersById(@PathVariable Long id){
//            userService.deleteUser(id);
//
//        }
//
//    }
//
//
//
//
//
//}
