/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.repositories.CRUD;

import com.Reto2.Reto2.models.Productos;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author David
 */
public interface iProductosRepository extends MongoRepository<Productos, String>{
    
}
