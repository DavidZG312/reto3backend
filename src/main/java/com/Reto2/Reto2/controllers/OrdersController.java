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
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author David
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/all")
    public List<Orders> getAll() {
        return ordersService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Orders> getOrder(@PathVariable("id") Integer id) {
        return ordersService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Orders create(@RequestBody Orders order) {
        return ordersService.create(order);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Orders update(@RequestBody Orders order) {
        return ordersService.update(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id) {
        return ordersService.delete(id);
    }

    @GetMapping("/zona/{zone}")
    public List<Orders> getZone(@PathVariable("zone") String zone) {
        return ordersService.getZone(zone);
    }

    @GetMapping("/salesman/{id}")
    public List<Orders> getBySalesManId(@PathVariable("id") Integer id) {
        return ordersService.getBySalesManId(id);
    }

    @GetMapping("/state/{status}/{id}")
    public List<Orders> getByIdSalesManIdAndStatus(@PathVariable("id") Integer id, @PathVariable("status") String status) {
        return ordersService.getBySalesManIdAndStatus(id, status);
    }

    @GetMapping("/date/{registerDay}/{id}")
    public List<Orders> getByRegisterDayAndSalesManId(@PathVariable("registerDay") String registerDay, @PathVariable("id") Integer id) {
        return ordersService.getByRegisterDayAndSalesManId(registerDay, id);
    }
}
