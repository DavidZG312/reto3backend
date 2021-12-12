/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.repositories;

import com.Reto2.Reto2.models.Orders;
import java.text.ParseException;
import com.Reto2.Reto2.repositories.CRUD.iOrdersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.text.SimpleDateFormat;

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

    public List<Orders> findBySalesManId(Integer id) {
        return crudRepository.findBySalesManId(id);
    }
    
    public List<Orders> getBySalesManIdAndStatus(Integer id, String status){
        return crudRepository.findBySalesManIdAndStatus(id, status);
    }

    public List<Orders> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        try {
            return crudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
