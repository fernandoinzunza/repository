package com.example.examen.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ordenproductos")
public class OrdenProducto {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public int getOrden_Id() {
		return ordenId;
	}
	public void setOrden_Id(int ordenId) {
		this.ordenId = ordenId;
	}
	public int getProducto_id() {
		return producto_id;
	}
	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
	@Column(name="fecha_creacion",columnDefinition="date default CURRENT_DATE")
private Date fecha_creacion;
@Column(name="orden_id")
private int ordenId;
private int producto_id;
private int cantidad;
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
}
