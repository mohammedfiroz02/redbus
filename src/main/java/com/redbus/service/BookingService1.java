//package com.redbus.service;
//
//import com.redbus.entity.Booking;
//import com.redbus.entity.BusOperator;
//import com.redbus.exception.BusOperatorNotFoundException;
//import com.redbus.exception.BookingNotFoundException;
//import com.redbus.repository.BookingRepository;
//import com.redbus.repository.BusOperatorRepository;
//import jakarta.mail.MessagingException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class BookingService {
//
//    @Autowired
//    private BookingRepository repository;
//
//    @Autowired
//    private BusOperatorRepository busOperatorRepository;
//
//    @Autowired
//    private SmsService smsService;
//
//    @Autowired
//    private EmailService emailService;
//
//    public Booking createBooking(Booking booking) throws MessagingException {
//        // Validate and set BusOperator
//        BusOperator busOperator = busOperatorRepository.findById(booking.getBusOperator().getBusId())
//                .orElseThrow(() -> new BusOperatorNotFoundException("Bus Operator with ID " + booking.getBusOperator().getBusId() + " not found"));
//
//        booking.setBusOperator(busOperator);
//
//        // Booking details
//        String passengerName = booking.getPassengerName();
//        String seatNumber = booking.getSeatNumber();
//        String busNumber = busOperator.getBusNumber();
//        String passengerPhone = booking.getPassengerPhone();
//        String passengerEmail = booking.getToEmail();
//
//        // Compose confirmation message
//        String message = "Dear " + passengerName + ", your seat " + seatNumber +
//                " on bus " + busNumber + " has been booked successfully.";
//
//        // Save booking to DB
//        Booking savedBooking = repository.save(booking);
//
//        // Send SMS confirmation
//        smsService.sendSms(passengerPhone, message);
//
//        // Send plain email confirmation (no PDF)
//        String emailSubject = "Your Booking Confirmation";
//        String emailBody = "Dear " + passengerName + ",\n\nYour booking for seat " + seatNumber +
//                " on bus " + busNumber + " has been confirmed.\n\nThank you for choosing our service!";
//        emailService.sendSimpleEmail(passengerEmail, emailSubject, emailBody);
//
//        return savedBooking;
//    }
//
//    public Booking getBookingById(Long id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new BookingNotFoundException("Booking with ID " + id + " not found"));
//    }
//}
