package com.example.examen.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.examen.model.Usuario;
import com.example.examen.model.UsuarioDTO;
@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {
	@InjectMocks
	private UsuarioController UsuarioController;
	@Test
	public void testGetAll() {
		ResponseEntity<List<Usuario>> responseEntity = UsuarioController.getUsuarios();
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	@Test
	public void testGetById() {
		ResponseEntity<Optional<Usuario>> responseEntity = UsuarioController.getById(1);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	@Test
	public void testCrear() {
		UsuarioDTO dto= new UsuarioDTO();
		dto.setNombre("Prueba");
		ResponseEntity<Usuario> responseEntity = UsuarioController.create(dto);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	@Test
	public void testEliminar() {
		ResponseEntity<String> responseEntity = UsuarioController.delete(1);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	@Test
	public void testUpdate()
	{
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNombre("Nuevo nombre");
		ResponseEntity<String> responseEntity = UsuarioController.actualizar(1,dto);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
}
