package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;

@Data
public class BoardingGate {

    private int idBoardingGate;

    private String gate;

}
