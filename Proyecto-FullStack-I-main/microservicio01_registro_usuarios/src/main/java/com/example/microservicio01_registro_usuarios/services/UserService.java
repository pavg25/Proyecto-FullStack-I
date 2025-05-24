package com.example.microservicio01_registro_usuarios.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.microservicio01_registro_usuarios.models.entities.User;
import com.example.microservicio01_registro_usuarios.models.request.UserCreate;
import com.example.microservicio01_registro_usuarios.models.request.UserUpDate;
import com.example.microservicio01_registro_usuarios.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> obtenerTodos(){
        return userRepository.findAll();
    }

    public User obtenerPorId(int id){
        return userRepository.findById(id).orElse(null);
    }
    
    public User registrar(UserCreate usuario){
        try {
            User nuevoUsuario = new User();
            //campos de negocio//
            nuevoUsuario.setFechaCreacion(new Date());
            nuevoUsuario.setActivo(true);
            //campos que vienen del cliente//
            nuevoUsuario.setNombre(usuario.getNombre());
            nuevoUsuario.setMail(usuario.getEmail());
            nuevoUsuario.setPassword(usuario.getPassword());
            nuevoUsuario.setTelefono(usuario.getTelefono());

            return userRepository.save(nuevoUsuario);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Usuario registrado");
        }
    }

    private String hashearPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); 
        return encoder.encode(password);

    }

    public User modificar(UserUpDate modificado){
        User usuario = userRepository.findById(modificado.getId()).orElse(null); //orElse trae id o null dependiendo de lo que encuentre.microservicio01RegistroUsuariosApplication
        if(usuario == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No encontrado");
        }
        if(modificado.getNombre() != null){
            usuario.setNombre(modificado.getNombre());
        }
        if(modificado.getTelefono() != null){
            usuario.setTelefono(modificado.getTelefono());
        }
        if(modificado.getPassword() != null){
            usuario.setPassword(modificado.getPassword());
        }

        return userRepository.save(usuario);

    }


    public User obtenerUno(int id){
        return userRepository.findById(id).orElse(null);
    }



    public void eliminar (int id){
        User usuario = userRepository.findById(id).orElse(null);
        if(usuario == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrado");
            
        }
        userRepository.delete(usuario);
    }



    public User actualizar (UserUpDate body){
        User usuario = userRepository.findById(body.getId()).orElse(null);
        if(usuario == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario no encontrado");
        }

        if(body.getNombre() != null) {
            usuario.setNombre(body.getNombre());
        }

        if(body.getTelefono() != null) {
            usuario.setTelefono(body.getTelefono());
        }

        if(body.getPassword() != null) {
            usuario.setPassword(hashearPassword(body.getPassword()));
        }

        return userRepository.save(usuario);

        

    }

}
