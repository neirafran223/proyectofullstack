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

    // Relaciones: Debemos tener cuidado con las relaciones bidireccionales.
    // Si Usuario tiene Evento y Seguridad, ¿es ManyToOne o OneToMany?
    // Asumo ManyToOne aquí, lo que significa que un usuario puede estar asociado a UN evento y UNA seguridad.
    // Si un evento puede tener muchos usuarios, la relación OneToMany iría en Evento.
    // Dado tu modelo actual, lo dejo como ManyToOne aquí.

    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading para evitar ciclos infinitos
    @JoinColumn(name = "evento_id") // Columna FK en la tabla 'usuarios'
    private Evento evento;

    @ManyToOne(fetch = FetchType.LAZY) // Lazy loading
    @JoinColumn(name = "seguridad_id") // Columna FK en la tabla 'usuarios'
    private Seguridad seguridad;
}