//package com.redbus.entity;
//
//import jakarta.persistence.*;
//
//import java.util.Date;
//
//@Entity
//@Table(name = "bus_booking")
//
//public class Booking {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long bookingId;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "bus_id", nullable = false)
//    private BusOperator busOperator;
//    private String passengerName;
//
//    private String seatNumber;
//    private Date bookingDate;
//
//    private String passengerPhone;
//    private String toEmail;
//
//
//    public Long getBookingId() {
//        return bookingId;
//    }
//
//    public void setBookingId(Long bookingId) {
//        this.bookingId = bookingId;
//    }
//
//    public BusOperator getBusOperator() {
//        return busOperator;
//    }
//
//    public void setBusOperator(BusOperator busOperator) {
//        this.busOperator = busOperator;
//    }
//
//    public String getPassengerName() {
//        return passengerName;
//    }
//
//    public void setPassengerName(String passengerName) {
//        this.passengerName = passengerName;
//    }
//
//    public String getSeatNumber() {
//        return seatNumber;
//    }
//
//    public void setSeatNumber(String seatNumber) {
//        this.seatNumber = seatNumber;
//    }
//
//    public Date getBookingDate() {
//        return bookingDate;
//    }
//
//    public void setBookingDate(Date bookingDate) {
//        this.bookingDate = bookingDate;
//    }
//
//    public String getPassengerPhone() {
//        return passengerPhone;
//    }
//
//    public void setPassengerPhone(String passengerPhone) {
//        this.passengerPhone = passengerPhone;
//    }
//
//
//    public String getToEmail() {
//        return toEmail;
//    }
//
//    public void setToEmail(String toEmail) {
//        this.toEmail = toEmail;
//    }
//
//
//}
