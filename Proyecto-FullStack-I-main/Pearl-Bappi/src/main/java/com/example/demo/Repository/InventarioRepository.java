package com.example.demo.Repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.Model.InventarioModel;

@Repository
public class InventarioRepository {
    private ArrayList<InventarioModel> inventario = new ArrayList<>();


    public InventarioRepository() {

        inventario.add(new InventarioModel("001", "Carolina Herrera", "Fragancia de Mujer", 850000, 10) );
        inventario.add(new InventarioModel("002", "Hugo Boss", "Fragancia de Hombre", 50000, 14) );
        inventario.add(new InventarioModel("003", "Dior Sauvage", "Fragancia de Mujer", 120000, 19) );
        inventario.add(new InventarioModel("004", "versace", "Fragancia de Mujer", 115000, 3) );
        inventario.add(new InventarioModel("005", "Polo", "Fragancia de Hombre", 60000, 7) );
       /* posible agregado para el inventario.*/

    }
    public ArrayList<InventarioModel> obtenerTodos(){
        return inventario;
    }
    public InventarioModel obtenerUno(String id){
        for(InventarioModel im : inventario){
            if(im.getId().equals(id)){
                return im;

            }
        }
        return null;
    }

    public void insertar(InventarioModel nuevoProducto){
        inventario.add(nuevoProducto);
    }
    public void eliminar(InventarioModel eliminarProducto){
        inventario.remove(eliminarProducto);
    }
    
}
