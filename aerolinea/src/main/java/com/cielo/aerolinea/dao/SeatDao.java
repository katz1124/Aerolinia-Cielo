package com.cielo.aerolinea.dao;

import com.cielo.aerolinea.entities.BoardingGate;
import com.cielo.aerolinea.entities.Flight;
import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatDao extends JpaRepository<Seat,Integer> {
    public List<Seat> findByFlight(Flight flight);

    @Query("SELECT s from Seat s WHERE s.row= ?1 AND s.column= ?2 AND s.flight = ?3")
    public List<Seat> findSeatByRowColumn(Integer row,String column, Flight flight);

}
