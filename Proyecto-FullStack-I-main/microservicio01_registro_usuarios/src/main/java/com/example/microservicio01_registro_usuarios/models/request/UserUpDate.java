package com.example.microservicio01_registro_usuarios.models.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserUpDate {

    @NotBlank
    private int id;

    private String nombre;

    private String password;

    private String telefono;
    
}
