package com.redbus.service;

import com.redbus.entity.Booking;
import com.redbus.entity.Bus;
import com.redbus.entity.User;
import com.redbus.repository.BookingRepository;
import com.redbus.repository.BusRepository;
import com.redbus.repository.UserRepository;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BusRepository busRepository;
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;
    private final EmailService emailService;

    public BookingServiceImpl(BusRepository busRepository,
                              UserRepository userRepository,
                              BookingRepository bookingRepository,
                              EmailService emailService) {
        this.busRepository = busRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.emailService = emailService;
    }

    /**
     * Create a new Booking with optimistic locking and send email confirmation.
     */
    @Override
    @Transactional
    public Booking createBooking(Booking booking) {
        try {
            // Fetch User
            Long userId = booking.getUser().getId();
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

            // Fetch Bus
            Long busId = booking.getBus().getBusId();
            Bus bus = busRepository.findById(busId)
                    .orElseThrow(() -> new RuntimeException("Bus not found with ID: " + busId));

            // Check seat availability
            if (bus.getAvailableSeats() <= 0) {
                throw new RuntimeException("No seats available for this bus!");
            }

            // Reduce seat
            bus.setAvailableSeats(bus.getAvailableSeats() - 1);
            busRepository.save(bus);

            // Set entities
            booking.setUser(user);
            booking.setBus(bus);

            // Save booking
            Booking savedBooking = bookingRepository.save(booking);

            // Send email confirmation
            if (user.getEmail() != null) {
                String subject = "RedBus Booking Confirmation";
                String body = "Dear " + user.getUsername() + ",\n\n"
                        + "Your booking has been confirmed.\n"
                        + "Bus Number: " + bus.getBusNumber() + "\n"
                        + "Seat Number: " + booking.getSeatNumber() + "\n"
                        + "Boarding Point: " + bus.getBoardingPoint() + "\n"
                        + "Departure Date: " + bus.getDepartureDate() + "\n"
                        + "Departure Time: " + bus.getDepartureTime() + "\n\n"
                        + "Thank you for choosing RedBus!";
                emailService.sendSimpleEmail(user.getEmail(), subject, body);
            }

            return savedBooking;

        } catch (OptimisticLockingFailureException e) {
            throw new RuntimeException("Seat already booked by another user. Please try again.");
        }
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with ID: " + id));

        Bus bus = booking.getBus();
        bus.setAvailableSeats(bus.getAvailableSeats() + 1);
        busRepository.save(bus);

        bookingRepository.deleteById(id);
    }
}
