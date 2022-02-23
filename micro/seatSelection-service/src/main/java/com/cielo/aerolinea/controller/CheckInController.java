package com.cielo.aerolinea.controller;

import com.cielo.aerolinea.model.SeatSelectionModel;
import com.cielo.aerolinea.service.SeatSelectionService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class CheckInController {


    @Autowired
    SeatSelectionService seatSelectionService;




    //SEATSELECTION-SERVICE
    @GetMapping(value = "/seatSelectionServ/boardingpass/{idReservation}/{seat}")
    public ResponseEntity<SeatSelectionModel> selectSeat(@PathVariable("idReservation") int idReservation, @PathVariable("seat") String seat) {

        int row = Character.getNumericValue(seat.charAt(0));
        String column = String.valueOf(seat.charAt(1));
        SeatSelectionModel seatSelectionModel=seatSelectionService.getSeatSelectionModel(idReservation,row,column);

        return ResponseEntity.ok(seatSelectionModel);

    }

}
