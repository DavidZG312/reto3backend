/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.controllers;

import com.Reto2.Reto2.models.Orders;
import com.Reto2.Reto2.services.OrdersService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author David
 */
@RestController
@RequestMapping("/api/order")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/all")
    public List<Orders> getAll() {
        return ordersService.getAll();
    }

    @GetMapping("/{id}")
    public Orders getById(@PathVariable Integer id) {
        return ordersService.getById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Orders> update(@RequestBody Orders orders) {
        Orders p = ordersService.update(orders);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }

    @PostMapping("/new")
    public ResponseEntity<Orders> save(@RequestBody Orders orders) {
        Orders p = ordersService.save(orders);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        ordersService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //Reto 3:Ordenes de pedido asociadas a los asesores de una zona
    @GetMapping("/zona/{zone}")
    public List<Orders> findByZone(@PathVariable("zone") String zone) {
        return ordersService.findByZone(zone);
    }
}
