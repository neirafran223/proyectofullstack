package com.cosanostra.repository;

import com.cosanostra.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByRut(String rut);

    Optional<Usuario> findByCorreo(String correo);

    boolean existsByRut(String rut);

    boolean existsByCorreo(String correo);
}