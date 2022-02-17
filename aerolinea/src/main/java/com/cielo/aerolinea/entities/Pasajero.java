package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "pasajero")
public class Pasajero {
    @Id
    @Column(name = "id_pasajero", nullable = false)
    private Long idPasajero;

    private String pasaporte;
    private String nombre;
    private int edad;
    private String correo;
}
