package com.jpa.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.app.dao.daoAdministrador;
import com.jpa.app.entity.Administrador;

@Service
public class implAdministrador implements serAdministrador {

    @Autowired
    private daoAdministrador dao;

    @Override
    @Transactional(readOnly = true)
    public List<Administrador> findAll() {
        return (List<Administrador>) dao.findAll();
    }

    @Override
    @Transactional
    public Administrador save(Administrador administrador) {
        return dao.save(administrador);
    }

    @Override
    @Transactional(readOnly = true)
    public Administrador findById(Long idAdministrador) {
        return dao.findById(idAdministrador).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long idAdministrador) {
        dao.deleteById(idAdministrador);
    }
}
