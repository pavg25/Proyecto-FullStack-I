package com.example.demo.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.InventarioModel;
import com.example.demo.Service.InventarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("inventario")
public class InventarioControllers {


    @Autowired
    private InventarioService sInventario;

    @GetMapping("")
    public ArrayList<InventarioModel> todos(){
        return sInventario.obtenerTodos();
    }


    
    @GetMapping("/{id}")
    public InventarioModel obtenerUno(@PathVariable String id){
        System.out.println(">>>>>Id buscando: "+id);
        return sInventario.obtenerUno(id);
    }



    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable String id){
        sInventario.eliminar(id);
        return "Producto Eliminado!";
    }



    @PostMapping("")
    public String agregar(@Valid @RequestBody InventarioModel inventario){
        sInventario.agregar(inventario);
        return "Producto Agregado!";
    }



      @PutMapping("/{id}")
    public String modificar(@PathVariable String id,@Valid @RequestBody InventarioModel  inventario){
        sInventario.modificar(id, inventario);

        return "Producto Modificado!";
    }





    
}
