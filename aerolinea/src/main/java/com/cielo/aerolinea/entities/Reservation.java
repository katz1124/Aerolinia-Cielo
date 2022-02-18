package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column(name = "id_reservation", nullable = false)
    private int idReservation;

    @Column(name = "id_flight")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "id_passenger")
    private Passenger passenger;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "purchase_date")
    private Date purchaseDate;

}
