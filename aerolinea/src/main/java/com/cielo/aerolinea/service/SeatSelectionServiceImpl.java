package com.cielo.aerolinea.service;

import com.cielo.aerolinea.dao.BoardingPassDao;
import com.cielo.aerolinea.dao.FlightDao;
import com.cielo.aerolinea.dao.ReservationDao;
import com.cielo.aerolinea.dao.SeatDao;
import com.cielo.aerolinea.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SeatSelectionServiceImpl implements  SeatSelectionService{

    @Autowired
    ReservationDao reservationDao;
    @Autowired
    BoardingPassDao boardingPassDao;
    @Autowired
    SeatDao seatDao;
    @Autowired
    FlightDao flightDao;




    @Override
    public BoardingPass generateBoardingPass(int reservationId, int row, String column) {
        Reservation reservation=reservationDao.getById(reservationId);

        Seat seat=seatDao.findSeatByRowColumn(row,column,reservation.getFlight());
        seat.setStatus("occupied");
        if(seat==null){
            return null;
        }
        seatDao.save(seat);
        BoardingPass boardingPass= new BoardingPass();
        boardingPass.setSeat(seat);
        boardingPass.setReservation(reservation);

        return  boardingPassDao.save(boardingPass);
    }



    @Override
    public BoardingPass getBoardingPass(Reservation reservation) {
        return boardingPassDao.findByReservation(reservation);
    }



}
