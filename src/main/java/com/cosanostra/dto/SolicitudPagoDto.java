package com.cosanostra.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SolicitudPagoDto {

   private String usuarioId;
   private String ordenId;
   private BigDecimal monto;
   private String metodoPago;
   private String eventoId;

   /**
    * {
    * "usuarioId": "",
    * "eventoId": "",
    * "monto": 0.0,
    * "metodoPago": ""
    * }
    * 
    **/
}
