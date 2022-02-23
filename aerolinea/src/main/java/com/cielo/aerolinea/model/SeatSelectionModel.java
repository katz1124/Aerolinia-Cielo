package com.cielo.aerolinea.model;

import com.cielo.aerolinea.entities.BoardingPass;
import lombok.Data;

import java.util.Map;
@Data
public class SeatSelectionModel {
    private BoardingPass boardingPass;
    private Map<String,String> ticketData;
}
