package com.redbus.service;

import com.redbus.entity.BusOperator;
import com.redbus.repository.BusOperatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusOperatorService {

    private final BusOperatorRepository busOperatorRepository;

    public BusOperatorService(BusOperatorRepository busOperatorRepository) {
        this.busOperatorRepository = busOperatorRepository;
    }

    public List<BusOperator> searchByRoute(String route) {
        return busOperatorRepository.findByRoute(route);
    }

    public List<BusOperator> searchByOperatorName(String operatorName) {
        return busOperatorRepository.findByOperatorNameContainingIgnoreCase(operatorName);
    }

    public List<BusOperator> searchByRouteAndOperator(String route, String operatorName) {
        return busOperatorRepository.findByRouteAndOperatorNameContainingIgnoreCase(route, operatorName);
    }

    // Or return all buses
    public List<BusOperator> getAllBuses() {
        return busOperatorRepository.findAll();
    }
}
