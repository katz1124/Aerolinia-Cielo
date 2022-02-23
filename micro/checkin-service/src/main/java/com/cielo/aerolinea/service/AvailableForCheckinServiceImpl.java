package com.cielo.aerolinea.service;

import com.cielo.aerolinea.dao.BoardingPassDao;
import com.cielo.aerolinea.dao.FlightDao;
import com.cielo.aerolinea.dao.ReservationDao;
import com.cielo.aerolinea.dao.SeatDao;
import com.cielo.aerolinea.entities.*;
import com.cielo.aerolinea.model.CheckinModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AvailableForCheckinServiceImpl implements AvailableForCheckinService {
    @Autowired
    ReservationDao reservationDao;
    @Autowired
    FlightDao flightDao;
    @Autowired
    SeatDao seatDao;
    @Autowired
    BoardingPassDao boardingPassDao;



    @Override
    public CheckinModel validateWithCode(String last_name, String reservationCode) {
        CheckinModel checkinModel = new CheckinModel();
        int id = GetId(reservationCode);
        Reservation reservation = reservationDao.findById(id).orElse(null);
        checkinModel.setReservation(reservation);
        Flight flight=reservation.getFlight();
        if (reservation == null) {
            return null;
        }
        if (boardingPassDao.findByReservation(reservation)!=null){
            checkinModel.setBoardingpassExist(true);
            return checkinModel;
        }

        if (reservation.getPassenger().getLastName().equals(last_name)) {
            if(checkAvailability(reservation)){
                checkinModel.setSeats(getSeatsList(flight.getIdFlight()));
                checkinModel.setFlightCode(getFlightCode(reservation));
                checkinModel.setPassenger(getPassengerName(reservation));
                checkinModel.setReservation(reservation);
                checkinModel.setBoardingpassExist(false);
                return checkinModel;
            }
        }
        return null;
    }

    //Reservation code to Reservation id convertion
    private int GetId(String reservationCode) {
        //Format: RV-3581
        int id = 0;
        if (reservationCode.length() < 7) {
            return 0;
        }
        try {
            id = Integer.parseInt(reservationCode.substring(3));
            id -= 3580;

        } catch (NumberFormatException ex) {
            return 0;
        }
        return id;
    }

    private Boolean checkAvailability(Reservation reservation){
        Flight flight=reservation.getFlight();
        Date departure_time=flight.getDepartureDate();

        Date now=new Date();
        long difference_In_Time
                = departure_time.getTime() - now.getTime();
        long difference_In_Hours
                = (difference_In_Time
                / (1000 * 60 * 60));
        if(difference_In_Hours>48)
            return false;
        return true;
    }
    @Override
    public String getFlightCode(Reservation reservation) {
        Flight flight=reservation.getFlight();
        int flightid=3580+ flight.getIdFlight();
        String flightCode="FL-"+flightid;
        return flightCode;
    }

    @Override
    public String getPassengerName(Reservation reservation) {
        Passenger passenger=reservation.getPassenger();
        String passengerName=passenger.getName()+" "+passenger.getLastName();
        return passengerName;
    }


    @Override
    public List<Seat> getSeatsList(int idFlight) {
        Flight flight=flightDao.getById(idFlight);
        return seatDao.findByFlight(flight);
    }



}