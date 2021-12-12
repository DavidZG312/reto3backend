/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.services;

import com.Reto2.Reto2.models.Orders;
import com.Reto2.Reto2.repositories.OrdersRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public class OrdersService {
     @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> getAll() {
        return ordersRepository.getAll();
    }

    public Orders getById(Integer id) {
        return ordersRepository.getById(id).orElse(null);
    }

    public Orders update(Orders orders) {
        if (orders.getId() == null) 
            return orders;
        

        Optional<Orders> existeOrden = ordersRepository.getById(orders.getId());

        if (existeOrden.isEmpty()) 
            return orders;
        
         //System.out.println(existeOrden);
        Orders orders1 = new Orders(existeOrden.get().getId(), existeOrden.get().getRegisterDay(), orders.getStatus(), existeOrden.get().getSalesMan(), existeOrden.get().getProducts(), existeOrden.get().getQuantities());
        return ordersRepository.save(orders1);
    }

    public Orders save(Orders orders) {

        if (orders.getId()== null) 
            return orders;


        Optional<Orders> existeOrden = ordersRepository.getById(orders.getId());

        if (existeOrden.isPresent()) 
            return orders;
        

        return ordersRepository.save(orders);
    }

    public void delete(Integer id) {
        ordersRepository.delete(id);
    }
    
    //Ordenes de pedido asociadas a los asesores de una zona
    public List<Orders> findByZone(String zone) {
        return ordersRepository.findByZone(zone);
    }
    
    //Ordenes de pedido asociadas al asesor
    public List<Orders> findBySalesManId(Integer id) {
        return ordersRepository.findBySalesManId(id);
    }
    
    public List<Orders> getBySalesManIdAndStatus(Integer id, String status){
        return ordersRepository.getBySalesManIdAndStatus(id, status);
    }

    public List<Orders> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        return ordersRepository.getByRegisterDayAndSalesManId(registerDay,id);
    }
    
}
