package com.cielo.aerolinea.controller;

import com.cielo.aerolinea.entities.BoardingPass;
import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.entities.Seat;
import com.cielo.aerolinea.service.AvailableForCheckinService;
import com.cielo.aerolinea.service.EmailService;
import com.cielo.aerolinea.service.SeatSelectionService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class CheckInController {

    @Autowired
    AvailableForCheckinService availableForCheckinService;
    @Autowired
    SeatSelectionService seatSelectionService;
    @Autowired
    EmailService emailService;

    @GetMapping("/")
    public String home()
    {
        return "views/checkin/index";
    }

    @GetMapping("/{message}")
    public String homeWithMessage(@PathVariable("message") boolean message, Model model)
    {
        model.addAttribute("message", message);
        return "views/checkin/index";
    }

    @GetMapping(value = "/checkin", params = {"name","reservationCode"})
    public Reservation checkin(@RequestParam String name , @RequestParam String reservationCode) {

        return availableForCheckinService.validateWithCode(name,reservationCode);
    }


    @GetMapping("/checkin/{name}/{code}")
    public String checkin2(@PathVariable("name")String name,@PathVariable("code")String code,Model model) {
        Reservation reservation=availableForCheckinService.validateWithCode(name,code);

        if(reservation==null){
            //VISTA ALTERNATIVA "EL BOARDING PASS YA EXISTE"
            return "redirect:/true";
           }
        if(availableForCheckinService.boardingpassExists(reservation)){
            //VISTA ALTERNATIVA "EL BOARDING PASS YA EXISTE"
            return "redirect:/true";
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

    //@ResponseBody
    @GetMapping(value = "/checkin/boardingpass/{idReservation}/{seat}")
    public String boardingpass(@PathVariable("idReservation") int idReservation, @PathVariable("seat") String seat,Model model) {
        int row = Character.getNumericValue(seat.charAt(0));
        String column = String.valueOf(seat.charAt(1));
        BoardingPass boardingPass = seatSelectionService.generateBoardingPass(idReservation,row,column);
        Map<String,String> ticketData=seatSelectionService.getTicketInfo(boardingPass.getIdBoardingPass());
       
        model.addAttribute("seatNo",ticketData.get("seatNo"));
        model.addAttribute("flight", ticketData.get("vuelo"));
        model.addAttribute("boardingGate", ticketData.get("bGate"));
        model.addAttribute("departure", ticketData.get("depart"));
        model.addAttribute("arrive", ticketData.get("arrive"));
        model.addAttribute("passengerName", ticketData.get("passengerName"));
        model.addAttribute("origin", ticketData.get("origin"));
        model.addAttribute("destiny", ticketData.get("destiny"));
        model.addAttribute("seatType", ticketData.get("pos"));
        model.addAttribute("emergency", ticketData.get("emergencyD"));
        model.addAttribute("passport", ticketData.get("passport"));
        model.addAttribute("idBoardingPass", boardingPass.getIdBoardingPass());

        return "/views/ticket/ticket";

    }
    @GetMapping("/checkin/send/email/{idBoardingPass}")
    public String sendTicket(@PathVariable("idBoardingPass") int idBoardingPass) throws DocumentException, IOException {
        emailService.generateTicket(idBoardingPass);
        
        return "redirect:/";
    }
}
