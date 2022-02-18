package com.cielo.aerolinea.dao;

import com.cielo.aerolinea.entities.BoardingGate;
import com.cielo.aerolinea.entities.BoardingPass;
import com.cielo.aerolinea.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDao extends JpaRepository<Reservation,Integer> {

}
