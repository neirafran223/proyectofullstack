package com.cosanostra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cosanostra.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
}