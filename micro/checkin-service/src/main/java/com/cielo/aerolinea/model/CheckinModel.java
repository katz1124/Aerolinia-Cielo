package com.cielo.aerolinea.model;

import com.cielo.aerolinea.entities.*;
import lombok.Data;

import java.util.List;

@Data
public class CheckinModel {
    private String  flightCode;
    private String passenger;
    private List <Seat> Seats;
    private Integer reservationId;
    private Boolean boardingpassExist;
    private Reservation reservation;
}
