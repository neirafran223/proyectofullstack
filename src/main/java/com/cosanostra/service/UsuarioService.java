package com.cosanostra.service;

import com.cosanostra.dto.UsuarioRequest;
import com.cosanostra.dto.UsuarioResponse;
import com.cosanostra.exception.UsuarioNotFoundException;
import com.cosanostra.model.Usuario;
import com.cosanostra.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponse crearUsuario(UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setRut(request.getRut());
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEdad(request.getEdad());
        usuario.setCargo(request.getCargo());
        usuario.setCorreo(request.getCorreo());
        usuario.setContrasena(request.getContrasena());
        usuario.setEmpresa(request.getEmpresa());
        usuario.setEsEmpleado(request.isEsEmpleado());

        usuarioRepository.save(usuario);
        return mapToResponse(usuario);
    }

    public UsuarioResponse obtenerUsuarioPorRut(String rut) {
        Usuario usuario = usuarioRepository.findByRut(rut)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con RUT: " + rut));
        return mapToResponse(usuario);
    }

    public List<UsuarioResponse> listarTodosLosUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public UsuarioResponse actualizarUsuario(String rut, UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findByRut(rut)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con RUT: " + rut));

        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEdad(request.getEdad());
        usuario.setCargo(request.getCargo());
        usuario.setCorreo(request.getCorreo());
        usuario.setContrasena(request.getContrasena());
        usuario.setEmpresa(request.getEmpresa());
        usuario.setEsEmpleado(request.isEsEmpleado());

        usuarioRepository.save(usuario);
        return mapToResponse(usuario);
    }

    public void eliminarUsuario(String rut) {
        Usuario usuario = usuarioRepository.findByRut(rut)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con RUT: " + rut));
        usuarioRepository.delete(usuario);
    }

    private UsuarioResponse mapToResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getRut(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEdad(),
                usuario.getCargo(),
                usuario.getCorreo(),
                usuario.getEmpresa(),
                usuario.isEsEmpleado());
    }
}