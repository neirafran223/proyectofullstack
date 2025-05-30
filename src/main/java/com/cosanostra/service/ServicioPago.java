package com.cosanostra.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cosanostra.dto.RespuestaPagoDto;
import com.cosanostra.dto.SolicitudPagoDto;
import com.cosanostra.model.Pago;
import com.cosanostra.model.Usuario; // Importar Usuario
import com.cosanostra.model.Evento;   // Importar Evento
import com.cosanostra.model.Seguridad; // Importar Seguridad
import com.cosanostra.repository.PagoRepository;
import com.cosanostra.repository.UsuarioRepository; // Necesario para buscar Usuario
import com.cosanostra.repository.EventoRepository;   // Necesario para buscar Evento
import com.cosanostra.repository.SeguridadRepository; // Necesario para buscar Seguridad

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioPago {

    private final PagoRepository pagoRepositorio;
    private final UsuarioRepository usuarioRepository; // Inyectar UsuarioRepository
    private final EventoRepository eventoRepository;   // Inyectar EventoRepository
    private final SeguridadRepository seguridadRepository; // Inyectar SeguridadRepository

    @Transactional
    public RespuestaPagoDto procesarPago(SolicitudPagoDto solicitudPago) {
        Pago pago = new Pago();
        pago.setMonto(solicitudPago.getMonto());
        pago.setMetodoPago(solicitudPago.getMetodoPago());
        pago.setFechaPago(LocalDateTime.now());
        pago.setEstado(Pago.EstadoPago.COMPLETADO);
        pago.setTransaccionId(UUID.randomUUID().toString());

        // Obtener y asociar Usuario
        Usuario usuario = usuarioRepository.findById(solicitudPago.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + solicitudPago.getUsuarioId()));
        pago.setUsuario(usuario);

        // Obtener y asociar Evento
        Evento evento = eventoRepository.findById(solicitudPago.getEventoId())
                .orElseThrow(() -> new RuntimeException("Evento no encontrado con ID: " + solicitudPago.getEventoId()));
        pago.setEvento(evento);

        // Obtener y asociar Seguridad
        Seguridad seguridad = seguridadRepository.findById(solicitudPago.getSeguridadId())
                .orElseThrow(() -> new RuntimeException("Seguridad no encontrada con ID: " + solicitudPago.getSeguridadId()));
        pago.setSeguridad(seguridad);

        Pago pagoGuardado = pagoRepositorio.save(pago);

        return mostrarADto(pagoGuardado);
    }

    public List<RespuestaPagoDto> obtenerPagosPorUsuario(Long usuarioId) { // Tipo de parámetro Long
        return pagoRepositorio.findByUsuarioId(usuarioId)
                .stream()
                .map(this::mostrarADto)
                .collect(Collectors.toList());
    }

    public RespuestaPagoDto obtenerPagoPorId(Long id) {
        Pago pago = pagoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
        return mostrarADto(pago);
    }

    private RespuestaPagoDto mostrarADto(Pago pago) {
        RespuestaPagoDto dto = new RespuestaPagoDto();
        dto.setId(pago.getId());
        dto.setMonto(pago.getMonto());
        dto.setEstado(pago.getEstado());
        dto.setMetodoPago(pago.getMetodoPago());
        dto.setFechaPago(pago.getFechaPago());
        dto.setTransaccionId(pago.getTransaccionId());

        // Rellenar IDs de las relaciones en el DTO
        if (pago.getUsuario() != null) {
            dto.setUsuarioId(pago.getUsuario().getId());
        }
        if (pago.getEvento() != null) {
            dto.setEventoId(pago.getEvento().getId());
        }
        if (pago.getSeguridad() != null) {
            dto.setSeguridadId(pago.getSeguridad().getId());
        }
        return dto;
    }

    public List<RespuestaPagoDto> obtenerTodosLosPagos() {
        return pagoRepositorio.findAll()
                .stream()
                .map(this::mostrarADto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void eliminarPago(Long id) {
        if (!pagoRepositorio.existsById(id)) {
            throw new RuntimeException("Pago no encontrado con ID: " + id);
        }
        pagoRepositorio.deleteById(id);
    }
}