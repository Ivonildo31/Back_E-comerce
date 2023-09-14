package com.ecomerce.ecomerce.services;

import org.springframework.stereotype.Service;

import com.ecomerce.ecomerce.models.Usuario;

@Service
public interface UsuarioService {

    public Usuario salvar(Usuario usuario);
    
}
