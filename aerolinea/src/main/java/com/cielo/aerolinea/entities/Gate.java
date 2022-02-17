package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "gate")
public class Gate {
    @Id
    @Column(name = "id_gate", nullable = false)
    private Long idGate;

    private String sala;

}
