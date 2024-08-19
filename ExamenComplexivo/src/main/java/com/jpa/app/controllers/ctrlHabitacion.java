package com.jpa.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpa.app.entity.Habitacion;
import com.jpa.app.entity.Categoria;
import com.jpa.app.services.serHabitacion;
import com.jpa.app.services.serCategoria;

@RestController
@RequestMapping("/api")
public class ctrlHabitacion {

    @Autowired
    private serHabitacion serHabitacion;

    @Autowired
    private serCategoria serCategoria;

    // Listar todas las habitaciones
    @GetMapping("/habitaciones")
    public List<Habitacion> listar() {
        return serHabitacion.findAll();
    }

    // Buscar una habitación por ID
    @GetMapping("/habitaciones/{id}")
    public ResponseEntity<Habitacion> buscar(@PathVariable Long id) {
        Habitacion habitacion = serHabitacion.findById(id);
        if (habitacion != null) {
            return new ResponseEntity<>(habitacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear una nueva habitación
    @PostMapping("/habitaciones")
    @ResponseStatus(HttpStatus.CREATED)
    public Habitacion crear(@RequestBody Habitacion habitacion) {
    	habitacion = serHabitacion.save(habitacion);

        return habitacion;
    }


 // // Actualizar una habitación existente
    @PutMapping("/habitaciones/{id}")
    public ResponseEntity<Habitacion> actualizar(@RequestBody Habitacion habitacion, @PathVariable Long id) {
        Habitacion existingHabitacion = serHabitacion.findById(id);
        if (existingHabitacion != null) {
            existingHabitacion.setNumero(habitacion.getNumero());
            existingHabitacion.setDescripcion(habitacion.getDescripcion());
            existingHabitacion.setPrecio(habitacion.getPrecio());
            existingHabitacion.setEstado(habitacion.getEstado());
            existingHabitacion.setIdCategoria(habitacion.getIdCategoria()); // Añadir esta línea para actualizar la categoría
            Habitacion updatedHabitacion = serHabitacion.save(existingHabitacion);
            return ResponseEntity.ok(updatedHabitacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // Eliminar una habitación por ID
    @DeleteMapping("/habitaciones/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Habitacion habitacion = serHabitacion.findById(id);
        if (habitacion != null) {
            serHabitacion.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
