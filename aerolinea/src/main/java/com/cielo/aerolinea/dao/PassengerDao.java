package com.cielo.aerolinea.dao;

import com.cielo.aerolinea.entities.BoardingGate;
import com.cielo.aerolinea.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerDao extends JpaRepository<Passenger,Integer> {
}
