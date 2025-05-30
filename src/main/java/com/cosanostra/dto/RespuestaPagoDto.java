package com.cosanostra.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.cosanostra.model.Pago.EstadoPago;

import lombok.Data;
import lombok.NoArgsConstructor; // Añadido para consistencia con @Data
import lombok.AllArgsConstructor; // Añadido para consistencia con @Data

@Data
@NoArgsConstructor // Puedes añadir estos constructores para Lombok
@AllArgsConstructor
public class RespuestaPagoDto {

    private Long id;
    private BigDecimal monto;
    private EstadoPago estado;
    private String metodoPago;
    private LocalDateTime fechaPago;
    private String transaccionId;
    private Long usuarioId; // Para devolver el ID del usuario
    private Integer eventoId; // Para devolver el ID del evento
    private Integer seguridadId; // Para devolver el ID de seguridad
}