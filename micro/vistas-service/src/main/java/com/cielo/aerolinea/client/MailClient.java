package com.cielo.aerolinea.client;

import com.itextpdf.text.DocumentException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@FeignClient(name ="mail-service" ,url="localhost:8083")
public interface MailClient {
    //MAIL-SERVICE
    @GetMapping("/mailServ/{idBoardingPass}")
    public void sendTicket(@PathVariable("idBoardingPass") int idBoardingPass) throws DocumentException, IOException;
}
