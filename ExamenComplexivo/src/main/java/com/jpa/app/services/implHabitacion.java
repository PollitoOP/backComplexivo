package com.jpa.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.app.dao.daoHabitacion;
import com.jpa.app.entity.Habitacion;

import java.util.List;

@Service
public class implHabitacion implements serHabitacion {

    @Autowired
    private daoHabitacion dao;

    @Override
    @Transactional(readOnly = true)
    public List<Habitacion> findAll() {
        return (List<Habitacion>) dao.findAll();
    }

    @Override
    @Transactional
    public Habitacion save(Habitacion habitacion) {
        return dao.save(habitacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Habitacion findById(Long idHabitacion) {
        return dao.findById(idHabitacion).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long idHabitacion) {
        dao.deleteById(idHabitacion);
    }
}
