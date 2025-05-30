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
import com.cosanostra.repository.PagoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioPago {

    private final PagoRepository pagoRepositorio;

    @Transactional
    public RespuestaPagoDto procesarPago(SolicitudPagoDto solicitudPago) {
        // Simulación de procesamiento de pago
        Pago pago = new Pago();
        pago.setMonto(solicitudPago.getMonto());
        pago.setMetodoPago(solicitudPago.getMetodoPago());
        pago.setFechaPago(LocalDateTime.now());
        pago.setEstado(Pago.EstadoPago.COMPLETADO);
        pago.setTransaccionId(UUID.randomUUID().toString());

        Pago pagoGuardado = pagoRepositorio.save(pago);

        return mostrarADto(pagoGuardado);
    }

    public List<RespuestaPagoDto> obtenerPagosPorUsuario(String usuarioId) {
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
