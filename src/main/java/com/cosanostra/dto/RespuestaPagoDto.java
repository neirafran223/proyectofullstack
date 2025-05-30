package com.cosanostra.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.cosanostra.model.Pago.EstadoPago;

import lombok.Data;

@Data
public class RespuestaPagoDto {

    private Long id;
    private BigDecimal monto;
    private EstadoPago estado;
    private String metodoPago;
    private LocalDateTime fechaPago;
    private String transaccionId;

}
