//package com.redbus.repository;
//
//import com.redbus.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//
//import java.util.Optional;
//
//
//import com.redbus.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    // Fixed: Add parameter to the method
//    Optional<User> findByUsername(String username);
//
//    boolean existsByUsername(String username);
//
//    boolean existsByEmail(String email);
//
//    Optional<User> findByUsernameOrEmail(String username, String email);
//}
///