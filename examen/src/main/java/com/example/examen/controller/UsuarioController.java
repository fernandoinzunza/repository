package com.example.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.service.UsuarioServiceImpl;
import com.example.examen.model.Usuario;
import com.example.examen.model.UsuarioDTO;
@RequestMapping("/api/usuarios")
@RestController
public class UsuarioController {
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@GetMapping("/hola")
	public ResponseEntity<List<Usuario>> getUsuarios()
	{
		return ResponseEntity.ok(usuarioService.GetUsuarios());
	}
	@PostMapping("/crear")
	public ResponseEntity<Usuario> create(@RequestBody UsuarioDTO usuario){
		Usuario obj = new Usuario();
		obj.setNombre(usuario.getNombre());
		return ResponseEntity.ok(usuarioService.create(obj));
	}
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		Optional<Usuario> obj = usuarioService.GetById(id);
		if(obj.get() !=null) {
			usuarioService.delete(obj.get());
			return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado");
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
	}
	@GetMapping(value = "{id}")
	public ResponseEntity<Optional<Usuario>> getById(@PathVariable int id){
		return ResponseEntity.ok(usuarioService.GetById(id));
	}
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<String> actualizar(@PathVariable int id,@RequestBody UsuarioDTO usuario){
		var res = usuarioService.update(usuario, id);
		if(res == "OK")
			return ResponseEntity.ok(res);
		else
			return ResponseEntity.badRequest().body(res);
	}
}
