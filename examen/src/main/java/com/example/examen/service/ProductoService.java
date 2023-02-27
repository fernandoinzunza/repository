package com.example.examen.service;

import java.util.List;
import java.util.Optional;

import com.example.examen.model.Producto;
import com.example.examen.model.ProductoDTO;

public interface ProductoService {
	Producto create(Producto usuario);
	void delete(Producto usuario);
	List<Producto> getProductos();
	Optional<Producto> getById(int id);
	String update(ProductoDTO producto,int id);
}
