package com.redbus.service;

import com.redbus.entity.Bus;

import java.time.LocalDate;
import java.util.List;

public interface BusService {

    /**
     * Create and save a new Bus.
     *
     * @param bus The Bus entity to create.
     * @return The saved Bus.
     */
    Bus createBus(Bus bus);

    /**
     * Get all Buses.
     *
     * @return List of all Buses.
     */
    List<Bus> getAllBuses();

    /**
     * Get a Bus by its ID.
     *
     * @param id The Bus ID.
     * @return The found Bus.
     */
    Bus getBusById(Long id);

    /**
     * Update an existing Bus.
     *
     * @param id        The ID of the Bus to update.
     * @param updatedBus The Bus with updated details.
     * @return The updated Bus.
     */
    Bus updateBus(Long id, Bus updatedBus);

    /**
     * Delete a Bus by its ID.
     *
     * @param id The Bus ID.
     */
    void deleteBus(Long id);

    /**
     * Search Buses by city, departure date, boarding point, and bus type.
     *
     * @param city          The city name.
     * @param departureDate The departure date.
     * @param boardingPoint The boarding point.
     * @param busType       The bus type.
     * @return List of matching Buses.
     */
    List<Bus> searchBuses(String city, LocalDate departureDate, String boardingPoint, String busType);
}
