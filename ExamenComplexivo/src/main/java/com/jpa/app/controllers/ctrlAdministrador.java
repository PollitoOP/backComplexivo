package com.jpa.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpa.app.entity.Administrador;
import com.jpa.app.services.serAdministrador;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ctrlAdministrador {

    @Autowired
    private serAdministrador servicio;

    @GetMapping("/administradores")
    public List<Administrador> listarAdministradores() {
        return servicio.findAll();
    }

    @GetMapping("/administradores/{id}")
    public ResponseEntity<Administrador> obtenerAdministradorPorId(@PathVariable Long id) {
        Administrador administrador = servicio.findById(id);
        if (administrador != null) {
            return new ResponseEntity<>(administrador, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/administradores")
    public ResponseEntity<Administrador> crearAdministrador(@RequestBody Administrador administrador) {
        Administrador nuevoAdministrador = servicio.save(administrador);
        return new ResponseEntity<>(nuevoAdministrador, HttpStatus.CREATED);
    }

    @PutMapping("/administradores/{id}")
    public ResponseEntity<Administrador> actualizarAdministrador(@PathVariable Long id, @RequestBody Administrador administradorDetalles) {
        Administrador administrador = servicio.findById(id);
        if (administrador != null) {
            administrador.setUsuario(administradorDetalles.getUsuario());
            administrador.setPassword(administradorDetalles.getPassword());
            administrador.setHabitaciones(administradorDetalles.getHabitaciones());

            Administrador administradorActualizado = servicio.save(administrador);
            return new ResponseEntity<>(administradorActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/administradores/{id}")
    public ResponseEntity<Void> eliminarAdministrador(@PathVariable Long id) {
        Administrador administrador = servicio.findById(id);
        if (administrador != null) {
            servicio.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
