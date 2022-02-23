package com.cielo.aerolinea.entities;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Data
public class Passenger implements Serializable{
    private static final long serialVersionUID = 1L;


    private int idPassenger;

    private String passport;

    private String name;

    private String lastName;

    private String email;

    private Date date;

}
