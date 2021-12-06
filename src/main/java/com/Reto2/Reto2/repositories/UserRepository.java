/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.repositories;

import com.Reto2.Reto2.models.Users;
import com.Reto2.Reto2.repositories.CRUD.iUsersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository
public class UserRepository {

    @Autowired
    private iUsersRepository crudRepository;

    public List<Users> getAll() {
        return crudRepository.findAll();
    }

    public Optional<Users> getById(Integer id) {
        return crudRepository.findById(id);
    }

    public Users save(Users users) {
        return crudRepository.save(users);
    }

    public void delete(Integer id) {
        crudRepository.deleteById(id);
    }

    public boolean existeEmail(String email) {
        Optional<Users> usuario = crudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }
    
    public Optional<Users> autenticarUsuario(String email, String password) {
        return crudRepository.findByEmailAndPassword(email, password);
    }

}
