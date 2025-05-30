package com.cosanostra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosanostra.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByUsuarioId(Long usuarioId); // Corregido a Long

    // Corregido a Integer, ya que Evento.id es Integer
    List<Pago> findByEventoId(Integer eventoId);

    // Añadido para buscar por Seguridad.id, que es Integer
    List<Pago> findBySeguridadId(Integer seguridadId);
}