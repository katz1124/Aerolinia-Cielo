package com.cielo.aerolinea.dao;

import com.cielo.aerolinea.entities.BoardingGate;
import com.cielo.aerolinea.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightDao extends JpaRepository<Flight,Integer> {
}
