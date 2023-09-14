package com.ecomerce.ecomerce.IMPL;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomerce.ecomerce.DTO.UsuarioDTO;
import com.ecomerce.ecomerce.models.Usuario;
import com.ecomerce.ecomerce.repository.UsuarioRepository;
import com.ecomerce.ecomerce.services.UsuarioService;

@Service
@Transactional 
public class UsuarioIMPL implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
	public Usuario salvar(Usuario usuarioDTO) {

        Usuario user = new Usuario();
        user.setNome(usuarioDTO.getNome());
        user.setEmail(usuarioDTO.getEmail());
        user.setSenha(usuarioDTO.getSenha());

        return usuarioRepository.save(user);
    }
    
}
