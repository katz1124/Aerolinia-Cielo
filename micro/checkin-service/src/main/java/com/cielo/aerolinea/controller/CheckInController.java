package com.cielo.aerolinea.controller;

import com.cielo.aerolinea.model.CheckinModel;
import com.cielo.aerolinea.service.AvailableForCheckinService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class CheckInController {

    @Autowired
    AvailableForCheckinService availableForCheckinService;



    //CHECKIN-SERVICE
    @GetMapping("/checkinServ/{name}/{code}")
    public ResponseEntity<CheckinModel>  checkIn(@PathVariable("name")String name, @PathVariable("code")String code) {

        return ResponseEntity.ok(availableForCheckinService.validateWithCode(name,code));

    }


}
