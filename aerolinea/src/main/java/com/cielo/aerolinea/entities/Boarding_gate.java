package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "boarding_gate")
public class Boarding_gate {
    @Id
    @Column(name = "id_boarding_gate", nullable = false)
    private Long idBoardingGate;

    private String gate;

}
