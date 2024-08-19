package com.jpa.app.services;

import java.util.List;

import com.jpa.app.entity.Administrador;

public interface serAdministrador {
    List<Administrador> findAll();
    Administrador save(Administrador administrador);
    Administrador findById(Long idAdministrador);
    void delete(Long idAdministrador);
}
