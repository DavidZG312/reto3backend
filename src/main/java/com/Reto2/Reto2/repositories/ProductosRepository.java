/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.repositories;

import com.Reto2.Reto2.models.Productos;
import com.Reto2.Reto2.repositories.CRUD.iProductosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository
public class ProductosRepository {
      @Autowired
    private iProductosRepository crudRepository;

    public List<Productos> getAll() {
        return crudRepository.findAll();
    }

    public Optional<Productos> getById(String reference) {
        return crudRepository.findById(reference);
    }

    public Productos save(Productos productos) {
        return crudRepository.save(productos);
    }

    public void delete(String reference) {
        crudRepository.deleteById(reference);
    }
}
