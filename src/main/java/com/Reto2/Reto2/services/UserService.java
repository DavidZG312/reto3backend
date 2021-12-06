/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.services;

import com.Reto2.Reto2.repositories.UserRepository;
import com.Reto2.Reto2.models.Users;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAll() {
        return userRepository.getAll();
    }

    public Users getById(Integer id) {
        return userRepository.getById(id).orElse(null);
    }

    public Users update(Users users) {
        if (users.getId() == null) 
            return users;
        

        Optional<Users> existeUsuario = userRepository.getById(users.getId());

        if (existeUsuario.isEmpty()) 
            return users;
        

        return userRepository.save(users);
    }

    public Users save(Users users) {

        if (users.getId() == null) 
            return users;


        Optional<Users> existeUsuario = userRepository.getById(users.getId());

        if (existeUsuario.isPresent()) 
            return users;
        

        return userRepository.save(users);
    }

    public void delete(Integer id) {
        userRepository.delete(id);
    }

    public boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }

    public Users autenticarUsuario(String email, String password) {
        Optional<Users> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new Users(null, null, null, null, null, null, null, null, null, null, null);
        } else {
            return usuario.get();
        }
    }

}
