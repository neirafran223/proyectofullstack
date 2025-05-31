package com.cosanostra.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cosanostra.dto.RespuestaPagoDto;
import com.cosanostra.dto.SolicitudPagoDto;
import com.cosanostra.service.ServicioPago;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final ServicioPago servicioPago;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RespuestaPagoDto procesarPago(@RequestBody SolicitudPagoDto solicitudPago) {
        return servicioPago.procesarPago(solicitudPago);
    }

    @GetMapping("/{id}")
    public RespuestaPagoDto obtenerPago(@PathVariable Long id) {
        return servicioPago.obtenerPagoPorId(id);
    }

    @GetMapping
    public List<RespuestaPagoDto> obtenerTodosLosPagos() {
        return servicioPago.obtenerTodosLosPagos();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPago(@PathVariable Long id) {
        servicioPago.eliminarPago(id);
    }
}