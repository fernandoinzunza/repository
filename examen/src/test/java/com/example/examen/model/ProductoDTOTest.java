package com.example.examen.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProductoDTOTest {
	@Test
	public void test() {
		ProductoDTO p = new ProductoDTO();
		p.setNombre("Producto 1");
		assertEquals("Producto 1",p.getNombre());
	}
}
