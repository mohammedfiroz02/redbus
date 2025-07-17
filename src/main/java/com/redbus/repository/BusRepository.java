package com.redbus.repository;

import com.redbus.entity.Bus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {

    // Example search: by city
    List<Bus> findByCityIgnoreCase(String city);

    // Example search: by departure date
    List<Bus> findByDepartureDate(LocalDate departureDate);

    // Example: by boarding point and city
    List<Bus> findByBoardingPointAndCity(String boardingPoint, String city);

    // Example: by city and bus type
    List<Bus> findByCityAndBusType(String city, String busType);

    // Example: custom combined search
    List<Bus> findByCityAndDepartureDate(String city, LocalDate departureDate);

    List<Bus> findByCityAndBoardingPoint(String city, String boardingPoint);
}
