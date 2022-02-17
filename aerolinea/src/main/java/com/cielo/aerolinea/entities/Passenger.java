package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "passenger")
public class Passenger {
    @Id
    @Column(name = "id_passenger", nullable = false)
    private int idPassenger;

    private String passport;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
}
