package com.cielo.aerolinea.service;

import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.entities.Seat;
import com.cielo.aerolinea.model.CheckinModel;

import java.util.List;

public interface AvailableForCheckinService {
    public CheckinModel validateWithCode(String last_name, String reservationCode);
    public String getFlightCode(Reservation reservation);
    public String getPassengerName(Reservation reservation);
    public List<Seat> getSeatsList(int idFlight);

}
