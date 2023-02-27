package com.example.examen.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrecioTest {
	@Test
	public void test() {
		Precio p = new Precio();
		p.setId(1);
		assertEquals(1,p.getId());
	}
}
