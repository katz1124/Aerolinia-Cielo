package com.cielo.aerolinea.controller;

import com.cielo.aerolinea.entities.BoardingPass;
import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.service.AvailableForCheckinService;
import com.cielo.aerolinea.service.SeatSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping
public class CheckInController {

    @Autowired
    AvailableForCheckinService availableForCheckinService;
    @Autowired
    SeatSelectionService seatSelectionService;


    @GetMapping(value = "/checkin", params = {"name","reservationCode"})
    public Reservation checkin(@RequestParam String name , @RequestParam String reservationCode) {

        return availableForCheckinService.validateWithCode(name,reservationCode);
    }

    @GetMapping(value = "/checkin/boardingpass")
    public BoardingPass boardingpass() {
        return seatSelectionService.generateBoardingPass(1,2,"B");
    }
}
