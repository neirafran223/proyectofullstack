package com.cosanostra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "seguridad")
@NoArgsConstructor
@AllArgsConstructor
public class Seguridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ID de tipo Integer

    @Column(unique = false)
    private String nombreEmpresa;

    @Column(unique = false)
    private int cantPersonal;

    @Column(unique = false)
    private String tipoSeguridad;
}