package com.example.microservicio01_registro_usuarios.models.request;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserCreate {



    private String nombre;
    
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    private String telefono;
    
}
