package com.cielo.aerolinea.service;

import com.cielo.aerolinea.dao.FlightDao;
import com.cielo.aerolinea.dao.ReservationDao;
import com.cielo.aerolinea.entities.Flight;
import com.cielo.aerolinea.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AvailableForCheckinServiceImpl implements AvailableForCheckinService {
    @Autowired
    ReservationDao reservationDao;
    @Autowired
    FlightDao flightDao;

    //Input validation.
    //If null, not available
    @Override
    public Reservation validateWithCode(String name, String reservationCode) {
        int id = GetId(reservationCode);
        Reservation reservation = reservationDao.findById(id).orElse(null);
        if (reservation == null) {
            return null;
        }
        if (reservation.equals(name)) {
            if(checkAvailability(reservation)){
                return reservation;
            }

        }

        return null;
    }

    //Reservation code to Reservation id convertion
    private int GetId(String reservationCode) {
        //Format: FL-3581
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



}