package com.cosanostra.controller;

import java.util.List;

import com.cosanostra.model.Seguridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cosanostra.service.SeguridadService;

@RestController
@RequestMapping("/api/v1/seguridad")
public class SeguridadController {

    @Autowired
    private SeguridadService seguridadService;

    @GetMapping
    public ResponseEntity<List<Seguridad>> Listar() {
        List<Seguridad> seguridad = seguridadService.findAll();
        if (seguridad.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(seguridad);
    }

    @PostMapping
    public ResponseEntity<Seguridad> guardar(@RequestBody Seguridad seguridad) {
        Seguridad productonuevo = seguridadService.save(seguridad);
        return ResponseEntity.status(HttpStatus.CREATED).body(productonuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seguridad> buscar(@PathVariable Integer id) {
        try {
            Seguridad seguridad = seguridadService.findById(id);
            return ResponseEntity.ok(seguridad);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seguridad> actualizar(@PathVariable Integer id, @RequestBody Seguridad seguridad) {
        try {
            Seguridad sgr = seguridadService.findById(id);
            sgr.setId(id);
            sgr.setNombreEmpresa(seguridad.getNombreEmpresa());
            sgr.setCantPersonal(seguridad.getCantPersonal());
            sgr.setTipoSeguridad(seguridad.getTipoSeguridad());

            seguridadService.save(sgr);
            return ResponseEntity.ok(seguridad);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        try {
            seguridadService.delate(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}