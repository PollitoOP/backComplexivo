package com.jpa.app.services;

import java.util.List;

import com.jpa.app.entity.Habitacion;

public interface serHabitacion {
    List<Habitacion> findAll();
    Habitacion save(Habitacion habitacion);
    Habitacion findById(Long idHabitacion);
    void delete(Long idHabitacion);
}