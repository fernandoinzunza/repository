package com.example.examen.service;

import java.util.List;
import java.util.Optional;

import com.example.examen.model.Usuario;
import com.example.examen.model.UsuarioDTO;

public interface UsuarioService {
	Usuario create(Usuario usuario);
	void delete(Usuario usuario);
	List<Usuario> GetUsuarios();
	Optional<Usuario> GetById(int id);
	String update(UsuarioDTO dto,int id);
	
}
