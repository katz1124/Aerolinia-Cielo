package com.cielo.aerolinea.controller;

import com.cielo.aerolinea.entities.BoardingPass;
import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.entities.Seat;
import com.cielo.aerolinea.model.CheckinModel;
import com.cielo.aerolinea.model.SeatSelectionModel;
import com.cielo.aerolinea.service.VistaService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping
public class CheckInController {


    @Autowired
    VistaService vistaService;

    @GetMapping("/")
    public String home()
    {
        return "views/checkin/index";
    }


    //CHECKIN-SERVICE
    @GetMapping("/checkin/{name}/{code}")
    public String checkin2(@PathVariable("name")String name,@PathVariable("code")String code,Model model) {

        CheckinModel checkinModel =vistaService.getCheckinModel(name,code);
        Reservation reservation=checkinModel.getReservation();

        if(reservation==null){
            //VISTA ALTERNATIVA "EL BOARDING PASS YA EXISTE"
            return "redirect:/";
           }
        if(checkinModel.getBoardingpassExist()){
            //VISTA ALTERNATIVA "EL BOARDING PASS YA EXISTE"
            return "redirect:/";
        }

        List<Seat> seats= checkinModel.getSeats();
        int reservationId=reservation.getIdReservation();
        double rows = Math.ceil(((double) seats.size() / 4));
        String passenger=checkinModel.getPassenger();
        String flight=checkinModel.getFlightCode();

        model.addAttribute("passenger",passenger);
        model.addAttribute("rows", (int) Math.round(rows));
        model.addAttribute("flight",flight);
        model.addAttribute("seats",seats);
        model.addAttribute("reservationid",reservationId);

        return "/views/planeroom/planeroom";
    }

    //SEAT SELECTION-SERVICE
    @GetMapping(value = "/checkin/boardingpass/{idReservation}/{seat}")
    public String boardingpass(@PathVariable("idReservation") int idReservation, @PathVariable("seat") String seat,Model model) {

        int row = Character.getNumericValue(seat.charAt(0));
        String column = String.valueOf(seat.charAt(1));
        SeatSelectionModel seatSelectionModel=vistaService.getSeatSelectionModel(idReservation,seat);
        BoardingPass boardingPass = seatSelectionModel.getBoardingPass();
        Map<String,String> ticketData=seatSelectionModel.getTicketData();
       
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
        vistaService.sendTicket(idBoardingPass);
        return "redirect:/";
    }
}
