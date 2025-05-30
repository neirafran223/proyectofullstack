package com.cosanostra.model;

import java.time.LocalTime;
import java.util.Date;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "evento") // Cambiado a minúsculas por convención y consistencia
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ID de tipo Integer

    @Column(unique = false) // 'unique = false' es redundante para columnas no únicas
    private String nombre;

    @Column(unique = false)
    private String ubicacion;

    @Column(unique = false)
    private Date fecha;

    @Column(unique = false)
    private LocalTime hora;

    @Column(unique = false)
    private int cantPersonas;

    @Column(unique = false)
    private int cantSeguridad;

    @Column(unique = false)
    private String tipoEvento;

    // Relación con Seguridad: Si un Evento tiene *una* empresa de seguridad asignada.
    // Si una empresa de seguridad puede estar en *muchos* eventos, esto debería ser ManyToOne en Evento.
    // Si una empresa de seguridad es *sólo para un* evento, entonces OneToOne o ManyToOne en Seguridad.
    // Según tu Evento.java, tiene ManyToOne seguridad, lo cual implica que un evento está relacionado con UNA Seguridad.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seguridad_id") // Columna FK en la tabla 'evento'
    private Seguridad seguridad;

    // Eliminar esta relación, ya que Pago es quien referencia a Evento, no al revés.
    // @ManyToOne
    // private Pago pago;
}