package com.cielo.aerolinea.service;

import com.cielo.aerolinea.dao.BoardingPassDao;
import com.cielo.aerolinea.dao.ReservationDao;
import com.cielo.aerolinea.dao.SeatDao;
import com.cielo.aerolinea.entities.BoardingPass;
import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.entities.Seat;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class SeatSelectionServiceImpl implements  SeatSelectionService{

    @Autowired
    ReservationDao reservationDao;
    @Autowired
    BoardingPassDao boardingPassDao;
    @Autowired
    SeatDao seatDao;


    @Override
    public BoardingPass generateBoardingPass(Reservation reservation, Seat seat) {
        BoardingPass boardingPass= new BoardingPass();

        boardingPass.setSeat(seat);
        boardingPass.setReservation(reservation);

        return  boardingPassDao.save(boardingPass);
    }

    @Override
    public BoardingPass generateBoardingPass(Reservation reservation, int row, String column) {
        Seat seat=seatDao.findSeatByRowColumn(row,column);
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

    @Override
    public List<Seat> getSeatsList(int idFlight) {
        return seatDao.findByIdflight(idFlight);
    }
    //Selecciona y guarda el asiento
    @Override
    public Seat selectSeat(int row, String column) {
        Seat seat=seatDao.findSeatByRowColumn(row,column);
        seat.setStatus("occupied");
        if(seat==null){
            return null;
        }
        return seatDao.save(seat);
    }
}
