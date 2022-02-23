package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
public class Reservation {

    private int idReservation;

    private Flight flight;

    private Passenger passenger;

    private Date purchaseDate;

}
