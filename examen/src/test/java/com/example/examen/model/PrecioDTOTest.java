package com.example.examen.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class PrecioDTOTest {
	@Test
	public void test() {
		PrecioDTO p = new PrecioDTO();
		p.setValor("100");
		assertEquals("100",p.getValor());
	}
}
