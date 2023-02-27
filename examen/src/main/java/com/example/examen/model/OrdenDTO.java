package com.example.examen.model;

import java.util.List;

public class OrdenDTO {
	private Integer usuario_id;
	public Integer getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}
	public List<OrdenProductoDTO> getProductos() {
		return productos;
	}
	public void setProductos(List<OrdenProductoDTO> productos) {
		this.productos = productos;
	}
	private List<OrdenProductoDTO> productos;
}
