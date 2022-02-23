package com.cielo.aerolinea.controller;

import com.cielo.aerolinea.service.EmailService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class CheckInController {


    @Autowired
    EmailService emailService;



    //MAIL-SERVICE
    @GetMapping("/mailServ/{idBoardingPass}")
    public void sendTicket(@PathVariable("idBoardingPass") int idBoardingPass) throws DocumentException, IOException {
        emailService.generateTicket(idBoardingPass);

    }
}
