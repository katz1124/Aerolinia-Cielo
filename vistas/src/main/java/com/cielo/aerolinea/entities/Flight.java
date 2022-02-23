package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
public class Flight {

    private int idFlight;

    private String origin;
    private String destiny;

    private Date departureDate;

    private Date arrivalDate;

    private BoardingGate boardingGate;


}
