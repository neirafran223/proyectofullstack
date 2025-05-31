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

    @ManyToOne
    private Seguridad seguridad;
}