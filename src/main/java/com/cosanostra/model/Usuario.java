package com.cosanostra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID técnico autoincremental

    @Column(unique = true, nullable = false)
    private String rut; // Identificador natural, único

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private int edad;

    @Column
    private String cargo;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private String empresa;

    @Column(nullable = false)
    private boolean esEmpleado;

    @ManyToOne
    private Evento evento;

    @ManyToOne
    private Seguridad seguridad;
}