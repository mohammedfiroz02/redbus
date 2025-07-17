//package com.redbus.entity;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "bus_operator")
//public class BusOperator {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String operatorName;
//
//    @Column(nullable = false, unique = true)
//    private String busNumber;
//
//    @Column(nullable = false)
//    private int capacity;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "route_id", nullable = false)
//    private Route route;
//
//    @OneToMany(mappedBy = "busOperator", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Booking> bookings;
//
//    // --- Constructors ---
//    public BusOperator() {}
//
//    public BusOperator(String operatorName, String busNumber, int capacity, Route route) {
//        this.operatorName = operatorName;
//        this.busNumber = busNumber;
//        this.capacity = capacity;
//        this.route = route;
//    }
//
//    // --- Getters and Setters ---
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getOperatorName() {
//        return operatorName;
//    }
//
//    public void setOperatorName(String operatorName) {
//        this.operatorName = operatorName;
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
//    public int getCapacity() {
//        return capacity;
//    }
//
//    public void setCapacity(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public Route getRoute() {
//        return route;
//    }
//
//    public void setRoute(Route route) {
//        this.route = route;
//    }
//
//    public List<Booking> getBookings() {
//        return bookings;
//    }
//
//    public void setBookings(List<Booking> bookings) {
//        this.bookings = bookings;
//    }
//
//    @Override
//    public String toString() {
//        return "BusOperator{" +
//                "id=" + id +
//                ", operatorName='" + operatorName + '\'' +
//                ", busNumber='" + busNumber + '\'' +
//                ", capacity=" + capacity +
//                ", route=" + (route != null ? route.getRouteName() : "null") +
//                '}';
//    }
//}
