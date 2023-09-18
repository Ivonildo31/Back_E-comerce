package com.ecomerce.ecomerce.IMPL;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecomerce.ecomerce.excecoes.MsgGenericaPersonalizadaException;
import com.ecomerce.ecomerce.models.Usuario;
import com.ecomerce.ecomerce.repository.UsuarioRepository;
import com.ecomerce.ecomerce.services.UsuarioService;

@Service
@Transactional 
public class UsuarioIMPL implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    //criptografa a senha
    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
	public Usuario salvar(Usuario usuarioDTO) {

        Usuario user = new Usuario();
        user.setNome(usuarioDTO.getNome());
        user.setEmail(usuarioDTO.getEmail());
        user.setSenha(passwordEncoder().encode(usuarioDTO.getSenha()));

        return usuarioRepository.save(user);
    }

    @Override
    public List<Usuario> listarUsuario() {

        List<Usuario> usuario = usuarioRepository.findAll();

        if (usuario.isEmpty()) {
            throw new MsgGenericaPersonalizadaException("Sem usuários na base de dados!");
        }

        return usuario;
    }

    @Override
    public Usuario buscarUsuarioPorId(UUID id) {

        Optional<Usuario> user = usuarioRepository.findById(id);

        if (user == null) {
            throw new MsgGenericaPersonalizadaException("Usuário não Existe base de dados!");
        }

        return user.get();
    }
    
}
