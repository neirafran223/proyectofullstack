package com.cosanostra.repository;

import com.cosanostra.model.Seguridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguridadRepository extends JpaRepository<Seguridad, Integer> { // <-- ¡Cambio aquí: de Long a Integer!
}