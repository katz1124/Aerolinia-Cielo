package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "asiento")
@Data
public class Asiento {
    @Id
    @Column(name = "id_asiento", nullable = false)
    private Long idAsiento;

    private int fila;
    private String columna;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_vuelo")
    Vuelo vuelo;

    @Column(name = "fila_emergencia")
    private Boolean filaEmergencia;




}
