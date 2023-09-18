package com.ecomerce.ecomerce.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecomerce.ecomerce.models.Usuario;
import com.ecomerce.ecomerce.services.UsuarioService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @CrossOrigin
	@PostMapping
	public Usuario salvar(@RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);
	}

	@CrossOrigin
	@GetMapping("/todos")
	public List<Usuario> buscarUsuarios() {
	  return usuarioService.listarUsuario();
	}

	@CrossOrigin
	@GetMapping("/buscarUsuarioPorId/{id}")
	public Usuario buscarPorId(@PathVariable(value = "id") UUID id) {
		return usuarioService.buscarUsuarioPorId(id);
	}

    
}
