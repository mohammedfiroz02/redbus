//package com.redbus.service;
//
//import com.redbus.entity.Booking;
//import com.redbus.entity.Bus;
//import com.redbus.entity.User;
//import com.redbus.repository.BookingRepository;
//import com.redbus.repository.BusRepository;
//import com.redbus.repository.UserRepository;
//import org.springframework.dao.OptimisticLockingFailureException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
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
//     * Create a new Booking with optimistic locking.
//     */
//    @Override
//    @Transactional
//    public Booking createBooking(Booking booking) {
//
//        try {
//            // Fetch User by ID
//            Long userId = booking.getUser().getId();
//            User user = userRepository.findById(userId)
//                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
//
//            // Fetch Bus by ID with version
//            Long busId = booking.getBus().getBusId();
//            Bus bus = busRepository.findById(busId)
//                    .orElseThrow(() -> new RuntimeException("Bus not found with ID: " + busId));
//
//            // Check available seats
//            if (bus.getAvailableSeats() <= 0) {
//                throw new RuntimeException("No seats available for this bus!");
//            }
//
//            // Reduce available seats
//            bus.setAvailableSeats(bus.getAvailableSeats()-1);
//
//            // Save Bus -> triggers optimistic locking
//            busRepository.save(bus);
//
//            // Set managed entities
//            booking.setUser(user);
//            booking.setBus(bus);
//
//            // Save Booking -> triggers optimistic locking
//            return bookingRepository.save(booking);
//
//        } catch (OptimisticLockingFailureException e) {
//            throw new RuntimeException("Seat was already booked by another user. Please try again.");
//        }
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
//    @Transactional
//    public void cancelBooking(Long id) {
//        Booking booking = bookingRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id));
//
//        Bus bus = booking.getBus();
//        bus.setAvailableSeats(bus.getAvailableSeats() + 1); // Return seat back
//        busRepository.save(bus);
//
//        bookingRepository.deleteById(id);
//    }
//}
