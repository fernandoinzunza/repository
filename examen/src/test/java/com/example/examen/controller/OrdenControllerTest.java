package com.example.examen.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.examen.model.Orden;
import com.example.examen.model.OrdenDTO;
import com.example.examen.model.OrdenProducto;
import com.example.examen.model.OrdenProductoDTO;
import com.example.examen.model.Precio;
@ExtendWith(MockitoExtension.class)
public class OrdenControllerTest {
	@InjectMocks
	private OrdenController ordenController;
	@Test
	public void testGetAll() {
		ResponseEntity<List<Orden>> responseEntity = ordenController.getOrdenes();
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	@Test
	public void testGetById() {
		ResponseEntity<Orden> responseEntity = ordenController.getById(1);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	@Test
	public void testCrear() {
		OrdenDTO dto = new OrdenDTO();
		List<OrdenProductoDTO> productos =new ArrayList<>();
		OrdenProductoDTO p= new OrdenProductoDTO();
		p.setCantidad(1);
		p.setProducto_id(1);
		productos.add(p);
		dto.setProductos(productos);
		dto.setUsuario_id(1);
		ResponseEntity<String> responseEntity = ordenController.crear(dto);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	@Test
	public void testEliminar() {
		ResponseEntity<String> responseEntity = ordenController.eliminar(1);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	@Test
	public void testUpdate()
	{
		OrdenDTO o =new OrdenDTO();
		o.setUsuario_id(1);
		ResponseEntity<String> responseEntity = ordenController.actualizar(1,o);
		assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
		assertNotNull(responseEntity.getBody());
	}
	
}
