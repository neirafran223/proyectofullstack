package com.cosanostra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {
    private String rut;
    private String nombre;
    private String apellido;
    private int edad;
    private String cargo;
    private String correo;
    private String contrasena;
    private String empresa;
    private boolean esEmpleado;
}