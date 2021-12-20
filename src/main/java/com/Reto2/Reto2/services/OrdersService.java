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
import org.springframework.core.annotation.Order;
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

    public Optional<Orders> getOrder(Integer id) {
        return ordersRepository.getOrder(id);
    }

    public Orders create(Orders order) {
        //if (order.getId() != null) {
        //    return ordersRepository.create(order);
        //} else {
        //    return order;
       // }

        //obtiene el maximo id existente en la coleccion
        Optional<Orders> userIdMaximo = ordersRepository.lastOrderId();

        //si el id del Usaurio que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (order.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (userIdMaximo.isEmpty()) {
                order.setId(1);
            } //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
            else {
                order.setId(userIdMaximo.get().getId() + 1);
            }
        }

        Optional<Orders> e = ordersRepository.getOrder(order.getId());
        if (e.isEmpty()) {
                return ordersRepository.create(order);
        } else {
            return order;
        }
    }

    public Orders update(Orders order) {
        if (order.getId() != null) {
            Optional<Orders> orden = ordersRepository.getOrder(order.getId());
            if (!orden.isEmpty()) {

                if (order.getId() != null) {
                    orden.get().setId(order.getId());
                }
                if (order.getRegisterDay() != null) {
                    orden.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus() != null) {
                    orden.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orden.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orden.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    orden.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    orden.get().setQuantities(order.getQuantities());
                }
                ordersRepository.update(orden.get());
                return orden.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(Integer id) {
        return getOrder(id).map(order -> {
            ordersRepository.delete(order);
            return true;
        }).orElse(false);
    }

    public List<Orders> getZone(String zone) {
        return ordersRepository.getZone(zone);
    }

    public List<Orders> getBySalesManId(Integer id) {
        return ordersRepository.getBySalesManId(id);
    }

    public List<Orders> getBySalesManIdAndStatus(Integer id, String status) {
        return ordersRepository.getBySalesManIdAndStatus(id, status);
    }

    public List<Orders> getByRegisterDayAndSalesManId(String registerDay, Integer id) {
        return ordersRepository.getByRegisterDayAndSalesManId(registerDay, id);
    }

    public Orders create(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
