/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.controllers;

import com.Reto2.Reto2.models.Productos;
import com.Reto2.Reto2.services.ProductosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author David
 */
@RestController
@RequestMapping("/api/cookware")
public class ProductosController {
        @Autowired
    private ProductosService productosService;

    @GetMapping("/all")
    public List<Productos> getAll() {
        return productosService.getAll();
    }

    @GetMapping("/{reference}")
    public Productos getById(@PathVariable String reference) {
        return productosService.getById(reference);
    }

    @PutMapping("/update")
    public ResponseEntity<Productos> update(@RequestBody Productos productos) {
        Productos p = productosService.update(productos);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }

    @PostMapping("/new")
    public ResponseEntity<Productos> save(@RequestBody Productos productos) {
        Productos p = productosService.save(productos);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        productosService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
