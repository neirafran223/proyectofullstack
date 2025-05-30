package com.cosanostra.model;

import java.math.BigDecimal; // Importar BigDecimal
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne; // Necesario para las relaciones
import jakarta.persistence.JoinColumn; // Necesario para definir las columnas de unión
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
    private BigDecimal monto; // Usar BigDecimal para el dinero

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    @Column(nullable = false)
    private String metodoPago;

    @Column(nullable = false)
    private LocalDateTime fechaPago;

    @Column
    private String transaccionId;

    // --- RELACIONES CON USUARIO, EVENTO Y SEGURIDAD ---

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false) // Columna FK en la tabla 'pagos'
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false) // Columna FK en la tabla 'pagos'
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "seguridad_id", nullable = false) // Columna FK en la tabla 'pagos'
    private Seguridad seguridad;

    public enum EstadoPago {
        PENDIENTE, COMPLETADO, FALLIDO, REEMBOLSADO
    }
}