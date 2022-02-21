package com.cielo.aerolinea.controller;

import com.cielo.aerolinea.entities.BoardingPass;
import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.entities.Seat;
import com.cielo.aerolinea.service.AvailableForCheckinService;
import com.cielo.aerolinea.service.SeatSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class CheckInController {

    @Autowired
    AvailableForCheckinService availableForCheckinService;
    @Autowired
    SeatSelectionService seatSelectionService;

    @GetMapping("/")
    public String home()
    {
        return "views/checkin/index";
    }

    @GetMapping(value = "/checkin", params = {"name","reservationCode"})
    public Reservation checkin(@RequestParam String name , @RequestParam String reservationCode) {

        return availableForCheckinService.validateWithCode(name,reservationCode);
    }
    /*
    @GetMapping(value = "/checkin2/{name}/{code}")
    public String checkin2(@PathVariable("name")String name,@PathVariable("code")String code) {
        Reservation reservation=availableForCheckinService.validateWithCode(name,code);
        if(reservation==null){
            return "views/checkin/checkin2";
        }
        else{
            return "views/planeroom/planeroom";
        }

    }
    */
    @GetMapping("/checkin/{name}/{code}")
    public String checkin2(@PathVariable("name")String name,@PathVariable("code")String code,Model model) {
        Reservation reservation=availableForCheckinService.validateWithCode(name,code);
        if(reservation==null){
            return "redirect:/";
           }
        int flightId=reservation.getFlight().getIdFlight();
        int reservationId=reservation.getIdReservation();
        String passenger= availableForCheckinService.getPassengerName(reservation);
        String flight= availableForCheckinService.getFlightCode(reservation);
        List<Seat> seats=availableForCheckinService.getSeatsList(flightId);
        double rows = Math.ceil(((double) seats.size() / 4));
        model.addAttribute("passenger",passenger);
        model.addAttribute("rows", (int) Math.round(rows));
        model.addAttribute("flight",flight);
        model.addAttribute("seats",seats);
        model.addAttribute("reservationid",reservationId);
        return "/views/planeroom/planeroom";


    }


    @GetMapping(value = "/checkin/boardingpass/{idFlight}/{idReservation}/{seat}")
    public String boardingpass(@PathVariable("idFlight") int idFlight, @PathVariable("idReservation") int idReservation, @PathVariable("seat") String seat) {
        int row = Character.valueOf(seat.charAt(0));
        String column = String.valueOf(seat.charAt(1));
        seatSelectionService.selectSeat(row, column, idFlight);
        BoardingPass boardingPass = seatSelectionService.generateBoardingPass(idReservation,row,column);
        
        if(boardingPass.equals(null)){
            return "redirect: /";
        }else{
            return "/views/ticket/ticket";
        }
    }
}
