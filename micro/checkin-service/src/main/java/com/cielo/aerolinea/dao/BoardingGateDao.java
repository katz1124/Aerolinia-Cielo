package com.cielo.aerolinea.dao;

import com.cielo.aerolinea.entities.BoardingGate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardingGateDao extends JpaRepository <BoardingGate,Integer> {
}
