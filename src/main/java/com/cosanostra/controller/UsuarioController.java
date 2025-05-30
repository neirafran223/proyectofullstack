package com.cosanostra.controller;

import com.cosanostra.dto.UsuarioRequest;
import com.cosanostra.dto.UsuarioResponse;
import com.cosanostra.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse crearUsuario(@RequestBody UsuarioRequest request) {
        return usuarioService.crearUsuario(request);
    }

    @GetMapping("/{rut}")
    public UsuarioResponse obtenerUsuarioPorRut(@PathVariable String rut) {
        return usuarioService.obtenerUsuarioPorRut(rut);
    }

    @GetMapping
    public List<UsuarioResponse> listarTodosLosUsuarios() {
        return usuarioService.listarTodosLosUsuarios();
    }

    @PutMapping("/{rut}")
    public UsuarioResponse actualizarUsuario(@PathVariable String rut, @RequestBody UsuarioRequest request) {
        return usuarioService.actualizarUsuario(rut, request);
    }

    @DeleteMapping("/{rut}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarUsuario(@PathVariable String rut) {
        usuarioService.eliminarUsuario(rut);
    }
}