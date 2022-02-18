package com.cielo.aerolinea.service;

import com.cielo.aerolinea.dao.BoardingPassDao;
import com.cielo.aerolinea.dao.FlightDao;
import com.cielo.aerolinea.dao.ReservationDao;
import com.cielo.aerolinea.dao.SeatDao;
import com.cielo.aerolinea.entities.BoardingPass;
import com.cielo.aerolinea.entities.Flight;
import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.entities.Seat;
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
    public BoardingPass generateBoardingPass(Reservation reservation, Seat seat) {
        BoardingPass boardingPass= new BoardingPass();

        boardingPass.setSeat(seat);
        boardingPass.setReservation(reservation);

        return  boardingPassDao.save(boardingPass);
    }

    @Override
    public BoardingPass generateBoardingPass(Reservation reservation, int row, String column) {

        List <Seat> seats=seatDao.findSeatByRowColumn(row,column,reservation.getFlight());
        Seat seat=seats.get(0);
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
    public BoardingPass generateBoardingPass(int reservationId, int row, String column) {
        Reservation reservation=reservationDao.getById(reservationId);
        return generateBoardingPass(reservation,row,column);
    }

    @Override
    public BoardingPass getBoardingPass(Reservation reservation) {
        return boardingPassDao.findByReservation(reservation);
    }

    @Override
    public List<Seat> getSeatsList(int idFlight) {
        Flight flight=flightDao.getById(idFlight);
        return seatDao.findByFlight(flight);
    }
    //Selecciona y guarda el asiento
    @Override
    public Seat selectSeat(int row, String column,int idFlight) {
        Flight flight=flightDao.getById(idFlight);
        List <Seat> seats=seatDao.findSeatByRowColumn(row,column,flight);
        Seat seat=seats.get(0);
        seat.setStatus("occupied");
        if(seat==null){
            return null;
        }
        return seatDao.save(seat);
    }
}
