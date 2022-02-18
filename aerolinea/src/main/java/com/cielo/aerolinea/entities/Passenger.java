package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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
    @Temporal(value = TemporalType.DATE)
    private Date date;
}
