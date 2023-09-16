package com.ecomerce.ecomerce.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecomerce.ecomerce.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,UUID> {

    @Query(value = "SELECT * FROM tb_usuario WHERE email = :email", nativeQuery = true)
    Usuario buscarPorEmail(String email);
    
}
