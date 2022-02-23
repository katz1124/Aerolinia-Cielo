package com.cielo.aerolinea.service;

import com.cielo.aerolinea.entities.BoardingPass;
import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.model.SeatSelectionModel;

import java.util.Map;

//Seat selection and boarding pass generator
public interface SeatSelectionService {

    public SeatSelectionModel getSeatSelectionModel(int reservationId,int row,String column);

    public Map <String,String> getTicketInfo(int idBoardingPass);
    public BoardingPass generateBoardingPass(int reservationId,int row,String column);

    public BoardingPass getBoardingPass(Reservation reservation);
    public Boolean boardingpassExists(int idReservation);
    public Integer getRows(int idReservation);




}
