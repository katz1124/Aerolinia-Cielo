package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "boarding_pass")
public class BoardingPass {
    @Id
    @Column(name = "id_boarding_pass", nullable = false)
    private Long idBoardingPass;

    @JoinColumn(name = "id_asiento")
    @OneToOne
    private Asiento asiento;

    @JoinColumn(name = "id_reserva")
    @OneToOne
    private Reserva reserva;


}
