package com.cielo.aerolinea.client;


import com.cielo.aerolinea.entities.BoardingPass;
import com.cielo.aerolinea.entities.Reservation;
import com.cielo.aerolinea.model.CheckinModel;
import com.cielo.aerolinea.model.SeatSelectionModel;
import com.itextpdf.text.DocumentException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@FeignClient(name ="checkin-service" ,url="localhost:8081")
public interface CheckinClient {

        //CHECKIN-SERVICE

    @GetMapping("/checkinServ/{name}/{code}")
    public ResponseEntity<CheckinModel> checkIn(@PathVariable("name")String name, @PathVariable("code")String code);





}
