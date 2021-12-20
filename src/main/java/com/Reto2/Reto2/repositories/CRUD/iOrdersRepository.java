/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.repositories.CRUD;

import com.Reto2.Reto2.models.Orders;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author David
 */
public interface iOrdersRepository extends MongoRepository<Orders, Integer> {

    List<Orders> findBySalesManZone(String zone);

    List<Orders> findBySalesManId(Integer id);

    List<Orders> findBySalesManIdAndStatus(Integer id, String status);

    List<Orders> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
    //Para seleccionar la orden con el id maximo

    Optional<Orders> findTopByOrderByIdDesc();
}
