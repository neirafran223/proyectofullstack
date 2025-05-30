package com.cosanostra.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pagos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal monto;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    @Column(nullable = false)
    private String metodoPago;

    @Column(nullable = false)
    private LocalDateTime fechaPago;

    @Column
    private String transaccionId;

    public enum EstadoPago {
        PENDIENTE, COMPLETADO, FALLIDO, REEMBOLSADO
    }
    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Evento evento;
}
