package com.cielo.aerolinea.dao;

import com.cielo.aerolinea.entities.BoardingGate;
import com.cielo.aerolinea.entities.Flight;
import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatDao extends JpaRepository<Seat,Integer> {
    public List<Seat> findByIdflight(int idflight);
    @Query("SELECT s from seat s WHERE u.row= ?1 and u.column= ?2")
    Seat findSeatByRowColumn(int row,String column);

}
