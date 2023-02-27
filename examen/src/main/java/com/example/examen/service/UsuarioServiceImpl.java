package com.example.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.model.Usuario;
import com.example.examen.model.UsuarioDTO;
import com.example.examen.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	public Usuario create(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	public void delete(Usuario usuario) {
	   usuarioRepository.delete(usuario);
	}
	public List<Usuario> GetUsuarios(){
		return usuarioRepository.findAll();
	}
	public Optional<Usuario> GetById(int id) {
		var u = usuarioRepository.findById(id);
		if(!u.isEmpty())
			return null;
		return u;
	}
	@Override
	public String update(UsuarioDTO dto, int id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		Usuario user = usuario.get();
		if(usuario !=null)
		{
			user.setNombre(dto.getNombre());
			usuarioRepository.save(user);
			return "OK";
		}
		else
			return "No existe el usuario";
	}
}
