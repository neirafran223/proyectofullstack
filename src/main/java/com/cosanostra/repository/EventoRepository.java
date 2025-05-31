package com.cosanostra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cosanostra.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
