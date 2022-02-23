package com.cielo.aerolinea.service;


import com.cielo.aerolinea.client.CheckinClient;
import com.cielo.aerolinea.entities.BoardingPass;
import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.entities.Seat;
import com.cielo.aerolinea.model.CheckinModel;
import com.cielo.aerolinea.model.SeatSelectionModel;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VistaServiceImpl implements  VistaService{

    @Autowired
    CheckinClient checkinClient;

    //checkin service
    @Override
    public CheckinModel getCheckinModel(String name, String code) {
        CheckinModel checkinModel=checkinClient.checkIn(name,code).getBody();
        return checkinModel;
    }
    //seatSelection service
    @Override
    public SeatSelectionModel getSeatSelectionModel(int idReservation, String seat) {
        SeatSelectionModel seatSelectionModel=checkinClient.selectSeat(idReservation,seat).getBody();
        return seatSelectionModel;
    }
    //checkin service
    @Override
    public void sendTicket(int boardingPassId) throws DocumentException, IOException {
        checkinClient.sendTicket(boardingPassId);
    }
}
