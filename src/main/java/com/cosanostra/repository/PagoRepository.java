package com.cosanostra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosanostra.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Si Usuario.id es Long:
    List<Pago> findByUsuarioId(Long usuarioId); // Cambiado de String a Long

    // Si Evento.id es Long (o el tipo que corresponda en Evento.java):
    List<Pago> findByEventoId(Long eventoId);   // Cambiado de String a Long (o Integer, etc.)
}