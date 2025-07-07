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
//    private EmailService emailService;
//
//    @Autowired
//    private SmsService smsService;
//
//    public Booking createBooking(Booking booking) throws MessagingException {
//        // Validate and set BusOperator
//        BusOperator busOperator = busOperatorRepository.findById(booking.getBusOperator().getBusId())
//                .orElseThrow(() -> new BusOperatorNotFoundException(
//                        "Bus Operator with ID " + booking.getBusOperator().getBusId() + " not found"
//                ));
//
//        booking.setBusOperator(busOperator);
//
//        // Booking details
//        String passengerName = booking.getPassengerName();
//        String seatNumber = booking.getSeatNumber();
//        String busNumber = busOperator.getBusNumber();
//        String passengerEmail = booking.getToEmail();
//        String passengerPhoneNumber = booking.getPassengerPhone(); // Make sure you have this field!
//
//        // Compose confirmation email
//        String emailSubject = "Your Booking Confirmation";
//        String emailBody = "Dear " + passengerName + ",\n\n"
//                + "Your booking for seat " + seatNumber
//                + " on bus " + busNumber + " has been confirmed.\n\n"
//                + "Thank you for choosing our service!";
//
//        // Compose SMS message
//        String smsMessage = "Hi " + passengerName + "! Your seat "
//                + seatNumber + " on bus " + busNumber + " is confirmed. Safe travels!";
//
//        // Save booking to DB
//        Booking savedBooking = repository.save(booking);
//
//        // Send email
//        emailService.sendSimpleEmail(passengerEmail, emailSubject, emailBody);
//
//        // Send SMS
//        smsService.sendSms(passengerPhoneNumber, smsMessage);
//
//        return savedBooking;
//    }
//
//    public Booking getBookingById(Long id) {
//        return repository.findById(id)
//                .orElseThrow(() -> new BookingNotFoundException(
//                        "Booking with ID " + id + " not found"
//                ));
//    }
//}
