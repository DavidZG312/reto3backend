/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.repositories.CRUD;

import com.Reto2.Reto2.models.Orders;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.Date;

/**
 *
 * @author David
 */
public interface iOrdersRepository extends MongoRepository<Orders, Integer> {
    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro

    @Query("{'salesMan.zone': ?0}")
    List<Orders> findByZone(final String zone);

    @Query("{'salesMan.id': ?0}")
    List<Orders> findBySalesManId(final Integer id);
    
    List<Orders> findBySalesManIdAndStatus(Integer id, String status);
    List<Orders> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
    
}
