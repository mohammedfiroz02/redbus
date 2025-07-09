package com.redbus.controller;

import com.redbus.entity.BusOperator;
import com.redbus.service.BusOperatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusOperatorController {

    private final BusOperatorService busOperatorService;

    public BusOperatorController(BusOperatorService busOperatorService) {
        this.busOperatorService = busOperatorService;
    }

    // Search by route
    @GetMapping("/search/route")
    public ResponseEntity<List<BusOperator>> searchByRoute(@RequestParam String route) {
        List<BusOperator> buses = busOperatorService.searchByRoute(route);
        return ResponseEntity.ok(buses);
    }

    // Search by operator name
    @GetMapping("/search/operator")
    public ResponseEntity<List<BusOperator>> searchByOperatorName(@RequestParam String operatorName) {
        List<BusOperator> buses = busOperatorService.searchByOperatorName(operatorName);
        return ResponseEntity.ok(buses);
    }

    // Search by route and operator
    @GetMapping("/search")
    public ResponseEntity<List<BusOperator>> searchByRouteAndOperator(
            @RequestParam String route,
            @RequestParam String operatorName) {
        List<BusOperator> buses = busOperatorService.searchByRouteAndOperator(route, operatorName);
        return ResponseEntity.ok(buses);
    }

    // Get all buses
    @GetMapping
    public ResponseEntity<List<BusOperator>> getAllBuses() {
        return ResponseEntity.ok(busOperatorService.getAllBuses());
    }
}
