package com.example.microservicio01_registro_usuarios.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import com.example.microservicio01_registro_usuarios.models.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    User findEmail(String email);
    
    
}
