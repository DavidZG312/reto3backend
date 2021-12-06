/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.repositories;

import com.Reto2.Reto2.models.Orders;
import com.Reto2.Reto2.repositories.CRUD.iOrdersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository
public class OrdersRepository {

    @Autowired
    private iOrdersRepository crudRepository;

    public List<Orders> getAll() {
        return crudRepository.findAll();
    }

    public Optional<Orders> getById(Integer id) {
        return crudRepository.findById(id);
    }

    public Orders save(Orders orders) {
        return crudRepository.save(orders);
    }

    public void delete(Integer id) {
        crudRepository.deleteById(id);
    }

    public List<Orders> findByZone(String zone) {
        return crudRepository.findByZone(zone);
    }
}
