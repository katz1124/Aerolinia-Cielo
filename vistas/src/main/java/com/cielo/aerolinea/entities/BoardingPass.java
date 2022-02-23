package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;

@Data
public class BoardingPass {

    private int idBoardingPass;


    private Seat seat;


    private Reservation reservation;


}
