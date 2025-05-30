package com.cosanostra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cosanostra.model.Seguridad;
import com.cosanostra.repository.SeguridadRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SeguridadService {

    @Autowired
    private SeguridadRepository seguridadRepository;

    public List<Seguridad> findAll() {
        return seguridadRepository.findAll();
    }

    // Cambiado 'long id' a 'Integer id'
    public Seguridad findById(Integer id) {
        return seguridadRepository.findById(id).get();
    }

    public Seguridad save(Seguridad seguridad) {
        return seguridadRepository.save(seguridad);
    }

    // Cambiado 'long id' a 'Integer id'
    public void delate(Integer id) {
        seguridadRepository.deleteById(id);
    }
}