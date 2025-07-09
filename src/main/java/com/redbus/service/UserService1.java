package com.redbus.service;//package com.redbus.service;
//
//
//import com.redbus.entity.User;
//import com.redbus.exception.ResourceNotFoundException;
//import com.redbus.payload.SignUpDto;
//import com.redbus.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//    @Autowired
//    private final PasswordEncoder passwordEncoder;
//
//    // ✅ Use constructor-based dependency injection
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public String registerUser(SignUpDto signUpDto) {
//        if (userRepository.existsByUsername(signUpDto.getUsername())) {
//            throw new RuntimeException("Username already taken");
//        }
//
//        if (userRepository.existsByEmail(signUpDto.getEmail())) {
//            throw new RuntimeException("Email already in use");
//        }
//
//        User user = new User();
//        user.setUsername(signUpDto.getUsername());
//        user.setEmail(signUpDto.getEmail());
//        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
//        // Set default roles
//        user.setRole("ROLE_USER");
//        userRepository.save(user);
//        return "User registered successfully!";
//    }
//
//    public String registerOperator(SignUpDto signUpDto) {
//        if (userRepository.existsByUsername(signUpDto.getUsername())) {
//            throw new RuntimeException("Username already taken");
//        }
//
//        if (userRepository.existsByEmail(signUpDto.getEmail())) {
//            throw new RuntimeException("Email already in use");
//        }
//        User user = new User();
//        user.setUsername(signUpDto.getUsername());
//        user.setEmail(signUpDto.getEmail());
//        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
//        // Set default roles
//        user.setRole("ROLE_OPERATOR");
//        userRepository.save(user);
//        return "Operator registered successfully!";
//    }
//
//
//    public User getUserById(Long id) {
//        return userRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
//    }
//
//    public User updateUser(Long id, User updatedUser) {
//        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
//        user.setUsername(updatedUser.getUsername());
//        user.setEmail(updatedUser.getEmail());
//        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
//
//        return userRepository.save(user);
//    }
//
//
//    public void deleteUser(Long id) {
//        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
//        userRepository.delete(user);
//
//    }
//
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//}
