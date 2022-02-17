package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "vuelo")
public class Vuelo {
    @Id
    @Column(name = "id_vuelo", nullable = false)
    private Long idVuelo;

    private String origen;
    private String destino;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "fecha_salida")
    private Date fechaSalida;
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "fecha_llegada")
    private Date fechaLlegada;

    @ManyToOne
    @JoinColumn(name = "id_gate")
    private Gate gate;


}
