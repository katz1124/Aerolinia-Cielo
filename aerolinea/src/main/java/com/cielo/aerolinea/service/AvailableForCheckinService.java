package com.cielo.aerolinea.service;

import com.cielo.aerolinea.entities.Reservation;

public interface AvailableForCheckinService {
    public Reservation validateWithCode(String name, String reservationCode);
}
