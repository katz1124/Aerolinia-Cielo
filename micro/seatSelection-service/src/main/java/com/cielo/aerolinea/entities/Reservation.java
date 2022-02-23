package com.cielo.aerolinea.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "reservation")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Reservation {
    @Id
    @Column(name = "id_reservation", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;

    @ManyToOne
    @JoinColumn(name = "id_flight")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "id_passenger")
    private Passenger passenger;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "purchase_date")
    private Date purchaseDate;

}
