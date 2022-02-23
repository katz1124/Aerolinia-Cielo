package com.cielo.aerolinea.entities;

import lombok.Data;

@Data
public class SeatSelectionModel {
    private Flight flight;
    private Boolean boardingPassExist;
    private BoardingPass boardingPass;
}
