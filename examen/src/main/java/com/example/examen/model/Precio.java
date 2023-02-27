package com.example.examen.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="precios")
public class Precio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private BigDecimal precio;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public BigDecimal getPrecio() {
	return precio;
}
public void setPrecio(BigDecimal precio) {
	this.precio = precio;
}
}
