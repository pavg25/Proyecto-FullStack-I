package com.example.microservicio01_registro_usuarios.models.entities;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;

    private String nombre;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false)
    private String password;

    private String telefono;

    @Column(name="fecha_creacion")
    private Date fechaCreacion;

    private Boolean activo;
    
}
