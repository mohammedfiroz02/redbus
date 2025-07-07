package com.redbus.repository;


import com.redbus.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {


    Optional<Otp> findByPhone(String phone);

    void deleteByExpiryTimeBefore(LocalDateTime now);
}

