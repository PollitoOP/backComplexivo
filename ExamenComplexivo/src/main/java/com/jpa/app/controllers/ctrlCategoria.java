package com.jpa.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpa.app.entity.Categoria;
import com.jpa.app.services.serCategoria;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ctrlCategoria {

    @Autowired
    private serCategoria servicio;

    @GetMapping("/categorias")
    public List<Categoria> listarCategorias() {
        return servicio.findAll();
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable Long id) {
        Categoria categoria = servicio.findById(id);
        if (categoria != null) {
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
        Categoria nuevaCategoria = servicio.Save(categoria);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoriaDetalles) {
        Categoria categoria = servicio.findById(id);
        if (categoria != null) {
            categoria.setNombre(categoriaDetalles.getNombre());
            categoria.setHabitaciones(categoriaDetalles.getHabitaciones());

            Categoria categoriaActualizada = servicio.Save(categoria);
            return new ResponseEntity<>(categoriaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        Categoria categoria = servicio.findById(id);
        if (categoria != null) {
            servicio.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

