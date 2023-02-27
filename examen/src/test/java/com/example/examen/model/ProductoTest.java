package com.example.examen.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductoTest {
@Test
public void test() {
	Producto p = new Producto();
	p.setId(1);
	assertEquals(1,p.getId());
}
}
