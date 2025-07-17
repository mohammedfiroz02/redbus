//package com.redbus.entity;
//
//import jakarta.persistence.*;
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//@Entity
//@Table(name = "buses")
//public class Bus {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long busId;
//
//    // Dates
//    @Column(nullable = false)
//    private LocalDate departureDate;
//
//    @Column(nullable = false)
//    private LocalTime departureTime;
//
//    @Column(nullable = false)
//    private String boardingPoint;
//
//    @Column(nullable = false, unique = true)
//    private String busNumber;
//
//    @Column(nullable = false)
//    private String busType;  // AC, NON-AC, Sleeper, etc.
//
//    @Column(nullable = false)
//    private String city;
//
//    @Column(nullable = false)
//    private LocalDate arrivalDate;
//
//    @Column(nullable = false)
//    private LocalTime arrivalTime;
//
//    @Column(nullable = false)
//    private String driverName;
//
//    @Column(nullable = false)
//    private int capacity;
//
//    @Column(nullable = true)
//    private String operatorEmail;
//
//    // --- Constructors ---
//    public Bus() {}
//
//    public Bus(LocalDate departureDate, LocalTime departureTime, String boardingPoint,
//               String busNumber, String busType, String city, LocalDate arrivalDate,
//               LocalTime arrivalTime, String driverName, int capacity, String operatorEmail) {
//        this.departureDate = departureDate;
//        this.departureTime = departureTime;
//        this.boardingPoint = boardingPoint;
//        this.busNumber = busNumber;
//        this.busType = busType;
//        this.city = city;
//        this.arrivalDate = arrivalDate;
//        this.arrivalTime = arrivalTime;
//        this.driverName = driverName;
//        this.capacity = capacity;
//        this.operatorEmail = operatorEmail;
//    }
//
//    // --- Getters and Setters ---
//
//    public Long getBusId() {
//        return busId;
//    }
//
//    public LocalDate getDepartureDate() {
//        return departureDate;
//    }
//
//    public void setDepartureDate(LocalDate departureDate) {
//        this.departureDate = departureDate;
//    }
//
//    public LocalTime getDepartureTime() {
//        return departureTime;
//    }
//
//    public void setDepartureTime(LocalTime departureTime) {
//        this.departureTime = departureTime;
//    }
//
//    public String getBoardingPoint() {
//        return boardingPoint;
//    }
//
//    public void setBoardingPoint(String boardingPoint) {
//        this.boardingPoint = boardingPoint;
//    }
//
//    public String getBusNumber() {
//        return busNumber;
//    }
//
//    public void setBusNumber(String busNumber) {
//        this.busNumber = busNumber;
//    }
//
//    public String getBusType() {
//        return busType;
//    }
//
//    public void setBusType(String busType) {
//        this.busType = busType;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public LocalDate getArrivalDate() {
//        return arrivalDate;
//    }
//
//    public void setArrivalDate(LocalDate arrivalDate) {
//        this.arrivalDate = arrivalDate;
//    }
//
//    public LocalTime getArrivalTime() {
//        return arrivalTime;
//    }
//
//    public void setArrivalTime(LocalTime arrivalTime) {
//        this.arrivalTime = arrivalTime;
//    }
//
//    public String getDriverName() {
//        return driverName;
//    }
//
//    public void setDriverName(String driverName) {
//        this.driverName = driverName;
//    }
//
//    public int getCapacity() {
//        return capacity;
//    }
//
//    public void setCapacity(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public String getOperatorEmail() {
//        return operatorEmail;
//    }
//
//    public void setOperatorEmail(String operatorEmail) {
//        this.operatorEmail = operatorEmail;
//    }
//
//
//
//}
