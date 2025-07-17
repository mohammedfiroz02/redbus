package com.redbus.service;

import com.redbus.entity.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> getAllBookings();
    List<Booking> getBookingsByUserId(Long userId);
    void cancelBooking(Long id);
}
