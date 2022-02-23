package com.cielo.aerolinea.service;

import com.cielo.aerolinea.entities.BoardingPass;
import com.cielo.aerolinea.model.CheckinModel;
import com.cielo.aerolinea.model.SeatSelectionModel;
import com.itextpdf.text.DocumentException;

import java.io.IOException;

public interface VistaService {
    public CheckinModel getCheckinModel(String name, String code);
    public SeatSelectionModel getSeatSelectionModel(int idReservation, String seat);
    public void sendTicket(int boardingPassId) throws DocumentException, IOException;

}
