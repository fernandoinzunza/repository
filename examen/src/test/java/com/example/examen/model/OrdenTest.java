package com.example.examen.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OrdenTest {
	@Test
	public void test() {
		Orden p = new Orden();
		p.setId(1);
		assertEquals(1,p.getId());
	}
}
