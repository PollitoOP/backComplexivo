package com.jpa.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.app.dao.daoCategoria;
import com.jpa.app.entity.Categoria;

@Service
public class implCategoria implements serCategoria {

    @Autowired
    private daoCategoria dao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return (List<Categoria>) dao.findAll();
    }

    @Override
    @Transactional
    public Categoria Save(Categoria categoria) {
        return dao.save(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria findById(Long idCategoria) {
        return dao.findById(idCategoria).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long idCategoria) {
        dao.deleteById(idCategoria);
    }
}
