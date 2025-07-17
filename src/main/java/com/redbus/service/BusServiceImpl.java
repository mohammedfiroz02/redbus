package com.redbus.service;

import com.redbus.entity.Bus;
import com.redbus.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Bus createBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public Bus getBusById(Long id) {
        return busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found with id: " + id));
    }

    @Override
    public Bus updateBus(Long id, Bus updatedBus) {
        Bus existing = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found with id: " + id));

        existing.setDepartureDate(updatedBus.getDepartureDate());
        existing.setDepartureTime(updatedBus.getDepartureTime());
        existing.setBoardingPoint(updatedBus.getBoardingPoint());
        existing.setBusNumber(updatedBus.getBusNumber());
        existing.setBusType(updatedBus.getBusType());
        existing.setCity(updatedBus.getCity());
        existing.setArrivalDate(updatedBus.getArrivalDate());
        existing.setArrivalTime(updatedBus.getArrivalTime());
        existing.setDriverName(updatedBus.getDriverName());
        existing.setCapacity(updatedBus.getCapacity());
        existing.setOperatorEmail(updatedBus.getOperatorEmail());

        return busRepository.save(existing);
    }

    @Override
    public void deleteBus(Long id) {
        if (busRepository.existsById(id)) {
            busRepository.deleteById(id);
        } else {
            throw new RuntimeException("Bus not found with id: " + id);
        }
    }

    @Override
    public List<Bus> searchBuses(String city, LocalDate departureDate, String boardingPoint, String busType) {
        if (city != null && departureDate != null) {
            return busRepository.findByCityAndDepartureDate(city, departureDate);
        } else if (city != null && busType != null) {
            return busRepository.findByCityAndBusType(city, busType);
        } else if (boardingPoint != null && city != null) {
            return busRepository.findByCityAndBoardingPoint(city, boardingPoint);
        } else if (city != null) {
            return busRepository.findByCityIgnoreCase(city);
        } else if (departureDate != null) {
            return busRepository.findByDepartureDate(departureDate);
        } else {
            return busRepository.findAll();
        }
    }
}
