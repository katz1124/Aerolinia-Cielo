package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "seat")
@Data
public class Seat {
    @Id
    @Column(name = "id_seat", nullable = false)
    private int idSeat;

    private int row;
    private String column;
    private String type;

    @ManyToOne
    @JoinColumn(name = "id_flight")
    private Flight flight;

    @Column(name = "emergency_near")
    private Boolean emergencyNear;




}
