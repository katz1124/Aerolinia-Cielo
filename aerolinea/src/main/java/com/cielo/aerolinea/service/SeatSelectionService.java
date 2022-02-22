package com.cielo.aerolinea.service;

import com.cielo.aerolinea.entities.BoardingPass;
import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.entities.Seat;

import java.util.List;
import java.util.Map;

//Seat selection and boarding pass generator
public interface SeatSelectionService {


    public BoardingPass generateBoardingPass(int reservationId,int row,String column);
    public BoardingPass getBoardingPass(Reservation reservation);



}
