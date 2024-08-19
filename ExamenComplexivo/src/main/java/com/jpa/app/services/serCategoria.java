package com.jpa.app.services;

import java.util.List;

import com.jpa.app.entity.Categoria;

public interface serCategoria {
    List<Categoria> findAll();
    Categoria Save(Categoria categoria);
    Categoria findById(Long idCategoria);
    void delete(Long idCategoria);
}

