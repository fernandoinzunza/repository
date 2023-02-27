package com.example.examen.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.examen.model.Orden;
import com.example.examen.model.OrdenDTO;
import com.example.examen.model.OrdenProductoDTO;
import com.example.examen.model.Producto;
import com.example.examen.model.ProductoDTO;

import org.mockito.InjectMocks;
@ExtendWith(MockitoExtension.class)
public class ProductoControllerTest {
	@InjectMocks
	private ProductoController productoController;
	@Test
	public void testGetAll() {
		ResponseEntity<List<Producto>> responseEntity = productoController.getProductos();
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	@Test
	public void testGetById() {
		ResponseEntity<Optional<Producto>> responseEntity = productoController.getById(1);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	@Test
	public void testCrear() {
		ProductoDTO dto= new ProductoDTO();
		dto.setNombre("Prueba");
		ResponseEntity<Producto> responseEntity = productoController.create(dto);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	@Test
	public void testEliminar() {
		ResponseEntity<String> responseEntity = productoController.delete(1);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	@Test
	public void testUpdate()
	{
		ProductoDTO dto = new ProductoDTO();
		dto.setNombre("Nuevo nombre");
		ResponseEntity<String> responseEntity = productoController.actualizar(1,dto);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
}
