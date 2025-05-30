package com.cosanostra.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cosanostra.model.Evento;
import com.cosanostra.repository.EventoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> findAll() {
        return eventoRepository.findAll();
    }

    // Cambiado 'long id' a 'Integer id'
    public Evento findById(Integer id) {
        return eventoRepository.findById(id).get();
    }

    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    // Cambiado 'long id' a 'Integer id'
    public void delate(Integer id) {
        eventoRepository.deleteById(id);
    }
}