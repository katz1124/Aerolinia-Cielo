package com.cielo.aerolinea.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "boarding_pass")
public class BoardingPass {
    @Id
    @Column(name = "id_boarding_pass", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBoardingPass;

    @JoinColumn(name = "id_seat")
    @OneToOne
    private Seat seat;
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "id_reservation")
    @OneToOne
    private Reservation reservation;


}
