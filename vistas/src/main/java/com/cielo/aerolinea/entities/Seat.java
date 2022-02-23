package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;


@Data
public class Seat {

    private int idSeat;

    private int row;

    private String column;

    private String type;

    private String status; //available, ocuppied

    private Flight flight;

    private Boolean emergencyNear;




}
