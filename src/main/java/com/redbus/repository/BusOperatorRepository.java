package com.redbus.repository;

import com.redbus.entity.BusOperator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusOperatorRepository extends JpaRepository<BusOperator, Long> {

    // Find by route
    List<BusOperator> findByRoute(String route);

    // Find by operator name
    List<BusOperator> findByOperatorNameContainingIgnoreCase(String operatorName);

    // Find by bus number
    List<BusOperator> findByBusNumber(String busNumber);

    // Find by route and operator name
    List<BusOperator> findByRouteAndOperatorNameContainingIgnoreCase(String route, String operatorName);

    // You can add more queries as needed!
}
