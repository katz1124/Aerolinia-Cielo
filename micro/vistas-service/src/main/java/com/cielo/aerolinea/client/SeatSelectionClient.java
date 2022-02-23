package com.cielo.aerolinea.client;

import com.cielo.aerolinea.model.SeatSelectionModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="seatSelection-service" ,url="localhost:8082")
public interface SeatSelectionClient {
    //SEATSELECTION-SERVICE
    @GetMapping(value = "/seatSelectionServ/boardingpass/{idReservation}/{seat}")
    public ResponseEntity<SeatSelectionModel> selectSeat(@PathVariable("idReservation") int idReservation, @PathVariable("seat") String seat);
}
