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

    @Id // La clave primaria es 'id'
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generada automáticamente por la base de datos
    private Long id;

    @Column(unique = true, nullable = false) // 'rut' es una columna única y no nula
    private String rut;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private int edad;

    @Column
    private String cargo; // Solo si trabaja en la empresa

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