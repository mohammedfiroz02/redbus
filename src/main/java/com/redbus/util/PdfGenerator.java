//package com.redbus.util;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.redbus.entity.Booking;
//
//import java.io.ByteArrayOutputStream;
//
//public class PdfGenerator {
//
//    public static byte[] generateBookingTicket(Booking booking) throws Exception {
//        Document document = new Document();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        PdfWriter.getInstance(document, out);
//        document.open();
//
//        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
//        Paragraph title = new Paragraph("RedBus Booking Ticket", titleFont);
//        title.setAlignment(Element.ALIGN_CENTER);
//        document.add(title);
//        document.add(Chunk.NEWLINE);
//
//        document.add(new Paragraph("Booking ID: " + booking.getId()));
//        document.add(new Paragraph("Name: " + booking.getUser().getUsername()));
//        document.add(new Paragraph("Email: " + booking.getUser().getEmail()));
//        document.add(new Paragraph("Route: " + booking.getRoute()));
//        document.add(new Paragraph("Date: " + booking.getTravelDate()));
//        document.add(new Paragraph("Seat No: " + booking.getSeatNumber()));
//        document.add(Chunk.NEWLINE);
//
//        document.add(new Paragraph("Thank you for booking with RedBus!"));
//        document.close();
//
//        return out.toByteArray();
//    }
//}
