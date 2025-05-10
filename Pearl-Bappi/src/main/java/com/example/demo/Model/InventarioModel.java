package com.example.demo.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
public  @Data class InventarioModel {
    private String id;


    @NotBlank
    private String nombre;



    @NotBlank
    private String descripcion;



    @Min(1)
    @Max(999999)
    @NotBlank
    private int precio;



    @Min(1)
    @Max(999)
    @NotBlank
    private int stock;

    
}
