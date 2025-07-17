//package com.redbus.controller;
//
//import com.redbus.entity.Bus;
//import com.redbus.entity.Bus;
//import com.redbus.repository.BusRepository;
//import com.redbus.repository.BusRepository;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//@RestController
//@RequestMapping("/api/bus-operators")
//public class BusOperatorController {
//
//    private final BusRepository busRepository;
//
//    public BusOperatorController(BusRepository busRepository) {
//        this.busRepository = busRepository;
//    }
//
//    // ✅ Save a new BusOperator
//    //http://localhost:8080/api/auth/bus-operators
//    @PostMapping("/create")
//    public Bus createBusOperator(@RequestBody Bus bus) {
//        return busRepository.save(bus);
//    }
//
//    // ✅ SEARCH endpoint (already there)
//   // http://localhost:8080/api/auth/bus-operators/search
//    @GetMapping("/search")
//    public List<Bus> searchBusOperators(
//            @RequestParam(required = false) String city,
//            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
//            @RequestParam(required = false) String boardingPoint,
//            @RequestParam(required = false) String busType
//    ) {
//        if (city != null && departureDate != null) {
//            return busRepository.findByCityAndDepartureDate(city, departureDate);
//        } else if (city != null && busType != null) {
//            return busRepository.findByCityAndBusType(city, busType);
//        } else if (boardingPoint != null && city != null) {
//            return busRepository.findByBoardingPointAndCity(boardingPoint, city);
//        } else if (city != null) {
//            return busRepository.findByCityIgnoreCase(city);
//        } else if (departureDate != null) {
//            return busRepository.findByDepartureDate(departureDate);
//        } else {
//            return busRepository.findAll();
//        }
//    }
//}
