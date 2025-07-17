//package com.redbus.service;
//
//import com.redbus.entity.Booking;
//import com.redbus.entity.Bus;
//import com.redbus.entity.User;
//import com.redbus.repository.BookingRepository;
//import com.redbus.repository.BusRepository;
//import com.redbus.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class BookingServiceImpl implements BookingService {
//
//    private final BusRepository busRepository;
//    private final UserRepository userRepository;
//    private final BookingRepository bookingRepository;
//
//    public BookingServiceImpl(BusRepository busRepository,
//                              UserRepository userRepository,
//                              BookingRepository bookingRepository) {
//        this.busRepository = busRepository;
//        this.userRepository = userRepository;
//        this.bookingRepository = bookingRepository;
//    }
//
//    /**
//     * Create a new Booking.
//     */
//    @Override
//    public Booking createBooking(Booking booking) {
//
//        // Fetch User by ID
//        Long userId = booking.getUser().getId();
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
//
//        // Fetch Bus by ID
//        Long busId = booking.getBus().getBusId();
//        Bus bus = busRepository.findById(busId)
//                .orElseThrow(() -> new RuntimeException("Bus not found with ID: " + busId));
//
//        // Set fully managed entities
//        booking.setUser(user);
//        booking.setBus(bus);
//
//        // Save booking
//        return bookingRepository.save(booking);
//    }
//
//    /**
//     * Get all Bookings.
//     */
//    @Override
//    public List<Booking> getAllBookings() {
//        return bookingRepository.findAll();
//    }
//
//    /**
//     * Get Bookings by User ID.
//     */
//    @Override
//    public List<Booking> getBookingsByUserId(Long userId) {
//        return bookingRepository.findByUserId(userId);
//    }
//
//    /**
//     * Cancel Booking by ID.
//     */
//    @Override
//    public void cancelBooking(Long id) {
//        if (!bookingRepository.existsById(id)) {
//            throw new RuntimeException("Booking not found with ID: " + id);
//        }
//        bookingRepository.deleteById(id);
//    }
//}
