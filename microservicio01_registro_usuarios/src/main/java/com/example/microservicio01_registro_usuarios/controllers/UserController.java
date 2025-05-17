package com.example.microservicio01_registro_usuarios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.microservicio01_registro_usuarios.models.entities.User;
import com.example.microservicio01_registro_usuarios.models.request.UserCreate;
import com.example.microservicio01_registro_usuarios.models.request.UserUpDate;
import com.example.microservicio01_registro_usuarios.services.UserService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> obtenerTodos() {
        return userService.obtenerTodos();
    }

   

    @PostMapping("/")
    public User registrar(@Valid @RequestBody UserCreate body) {
        return userService.registrar(body);
    }


    @PutMapping("/")
    public User modificar(@Valid @RequestBody UserUpDate body){
        return userService.modificar(body);
    }

    @DeleteMapping("/(id)")
    public String eliminar(@PathVariable int id ){
        userService.eliminar(id);
        return "ok";
    }


}
