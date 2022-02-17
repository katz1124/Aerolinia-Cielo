package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "reserva")
public class Reserva {
    @Id
    @Column(name = "id_reserva", nullable = false)
    private Long idReserva;

    @Column(name = "codigo_vuelo")
    private String codigoVuelo;

    @ManyToOne
    @JoinColumn(name = "id_pasajero")
    private Pasajero pasajero;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "fecha_compra")
    private Date fechaCompra;

}
