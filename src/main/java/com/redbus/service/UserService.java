package com.redbus.service;

import com.redbus.entity.User;
import com.redbus.exception.ResourceNotFoundException;
import com.redbus.payload.SignUpDto;
import com.redbus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // ✅ Constructor-based injection; Spring will autowire both args
    @Autowired
    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(SignUpDto signUpDto) {
        if (userRepository.existsByUsername(signUpDto.getUsername())) {
            throw new IllegalArgumentException("Username already taken: " + signUpDto.getUsername());
        }

        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            throw new IllegalArgumentException("Email already in use: " + signUpDto.getEmail());
        }

        User user = new User();
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setRole("ROLE_USER");

        userRepository.save(user);
        return "User registered successfully!";
    }

    public String registerOperator(SignUpDto signUpDto) {
        if (userRepository.existsByUsername(signUpDto.getUsername())) {
            throw new IllegalArgumentException("Username already taken: " + signUpDto.getUsername());
        }

        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            throw new IllegalArgumentException("Email already in use: " + signUpDto.getEmail());
        }

        User operator = new User();
        operator.setUsername(signUpDto.getUsername());
        operator.setEmail(signUpDto.getEmail());
        operator.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        operator.setRole("ROLE_OPERATOR");

        userRepository.save(operator);
        return "Operator registered successfully!";
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with ID: " + id)
                );
    }

    public User updateUser(Long id, User updatedUser) {
        User existing = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with ID: " + id)
                );

        existing.setUsername(updatedUser.getUsername());
        existing.setEmail(updatedUser.getEmail());
        existing.setPassword(passwordEncoder.encode(updatedUser.getPassword()));

        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        User existing = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with ID: " + id)
                );
        userRepository.delete(existing);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }
}
