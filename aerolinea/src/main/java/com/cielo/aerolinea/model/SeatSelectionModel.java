package com.cielo.aerolinea.model;

import com.cielo.aerolinea.entities.BoardingPass;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class SeatSelectionModel {
    private BoardingPass boardingPass;
    private Map<String,String> ticketData;
}