package com.example.examen.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="ordenes")
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
	@Column(name="fecha_creacion",columnDefinition="date default CURRENT_DATE")
private Date fecha_creacion;
private Integer usuario_id;
private BigDecimal total;

public BigDecimal getTotal() {
	return total;
}
public void setTotal(BigDecimal total) {
	this.total = total;
}
@ManyToOne
@JoinColumn(name = "usuario_id", referencedColumnName = "id",insertable = false,updatable = false)
@JsonIgnoreProperties("ordenes")
private Usuario usuario;

@OneToMany
@JoinColumn(name = "orden_id")
private List<OrdenProducto> productos;
public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public List<OrdenProducto> getProductos() {
	return productos;
}
public void setProductos(List<OrdenProducto> productos) {
	this.productos = productos;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Date getFecha_creacion() {
	return fecha_creacion;
}
public void setFecha_creacion(Date fecha_creacion) {
	this.fecha_creacion = fecha_creacion;
}
public Integer getUsuario_id() {
	return usuario_id;
}
public void setUsuario_id(Integer usuario_id) {
	this.usuario_id = usuario_id;
}
}
