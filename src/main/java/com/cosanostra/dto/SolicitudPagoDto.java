package com.cosanostra.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor; // Añadido para consistencia con @Data
import lombok.AllArgsConstructor; // Añadido para consistencia con @Data

@Data
@NoArgsConstructor // Puedes añadir estos constructores para Lombok
@AllArgsConstructor
public class SolicitudPagoDto {

   private Long usuarioId; // Corregido a Long (ID de Usuario)
   private Integer eventoId; // Corregido a Integer (ID de Evento)
   private Integer seguridadId; // Añadido para Seguridad (ID de Seguridad)
   private BigDecimal monto; // Asegúrate de que el tipo es BigDecimal
   private String metodoPago;
   private String ordenId; // Este campo puede ser String si no se relaciona con una entidad Order

   /**
    * {
    * "usuarioId": 1,
    * "eventoId": 101,
    * "seguridadId": 201,
    * "monto": 1500.50,
    * "metodoPago": "Tarjeta de Credito"
    * }
    *
    **/
}