package com.cielo.aerolinea.dao;

import com.cielo.aerolinea.entities.BoardingGate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardingGateDao extends JpaRepository <BoardingGate,Integer> {
}
