package com.redbus.controller;

import com.redbus.entity.Bus;
import com.redbus.service.BusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    /**
     * Create a new Bus.
     */
    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) {
        Bus savedBus = busService.createBus(bus);
        return ResponseEntity.ok(savedBus);
    }

    /**
     * Get all Buses.
     */
    @GetMapping
    public ResponseEntity<List<Bus>> getAllBuses() {
        List<Bus> buses = busService.getAllBuses();
        return ResponseEntity.ok(buses);
    }

    /**
     * Get a Bus by ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id) {
        Bus bus = busService.getBusById(id);
        return ResponseEntity.ok(bus);
    }

    /**
     * Update a Bus by ID.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Long id, @RequestBody Bus updatedBus) {
        Bus bus = busService.updateBus(id, updatedBus);
        return ResponseEntity.ok(bus);
    }

    /**
     * Delete a Bus by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
        busService.deleteBus(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Search Buses with optional query params.
     * Example: /api/buses/search?city=Delhi&departureDate=2025-07-16
     */
    @GetMapping("/search")
    public ResponseEntity<List<Bus>> searchBuses(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) LocalDate departureDate,
            @RequestParam(required = false) String boardingPoint,
            @RequestParam(required = false) String busType) {

        List<Bus> buses = busService.searchBuses(city, departureDate, boardingPoint, busType);
        return ResponseEntity.ok(buses);
    }
}
