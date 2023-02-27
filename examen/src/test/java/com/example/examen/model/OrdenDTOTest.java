package com.example.examen.model;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class OrdenDTOTest  {
	@Test
	public void test() {
		OrdenDTO dto = new OrdenDTO();
		dto.setUsuario_id(1);
		assertNotEquals(1, dto.getUsuario_id());
	}
}
