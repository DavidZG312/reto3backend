/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.controllers;

import com.Reto2.Reto2.models.Users;
import com.Reto2.Reto2.services.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author David
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<Users> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Users getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PutMapping("/update")
    public ResponseEntity<Users> update(@RequestBody Users persona) {
        Users u = userService.update(persona);
        return new ResponseEntity(u, HttpStatus.CREATED);
    }

    @PostMapping("/new")
    public ResponseEntity<Users> save(@RequestBody Users persona) {
        Users u = userService.save(persona);
        return new ResponseEntity(u, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{email}/{password}")
    public Users autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return userService.autenticarUsuario(email, password);
    }

    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return userService.existeEmail(email);
    }

}
