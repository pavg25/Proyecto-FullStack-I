package com.example.demo.Service;

import java.util.ArrayList;
import java.util.UUID;
import org.apache.coyote.http11.HttpOutputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.example.demo.Model.InventarioModel;
import com.example.demo.Repository.InventarioRepository;
@Service
public class InventarioService {


    @Autowired

    private InventarioRepository repo;

    public ArrayList<InventarioModel> obtenerTodos(){
        return repo.obtenerTodos();
    }


    public InventarioModel obtenerUno(String id){
        InventarioModel im = repo.obtenerUno(id);
        if(im == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return im;
    }


    public void agregar(InventarioModel inventarioModel){
        inventarioModel.setId(UUID.randomUUID().toString());
        repo.insertar(inventarioModel);
    }


    public void eliminar(String id){
        InventarioModel im =obtenerUno(id);
        repo.eliminar(im);
    }


    public void modificar(String id, InventarioModel modificarinventario){
        InventarioModel im = obtenerUno(id);
        im.setId(modificarinventario.getId());
        im.setNombre(modificarinventario.getNombre());
        im.setDescripcion(modificarinventario.getDescripcion());
        im.setPrecio(modificarinventario.getPrecio());
        im.setStock(modificarinventario.getStock());
    }


   



    
}
