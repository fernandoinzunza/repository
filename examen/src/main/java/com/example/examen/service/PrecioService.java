package com.example.examen.service;

import java.util.List;
import java.util.Optional;

import com.example.examen.model.Precio;
import com.example.examen.model.PrecioDTO;
import com.example.examen.model.Producto;
import com.example.examen.model.ProductoDTO;

public interface PrecioService {
	Precio create(Precio usuario);
	void delete(Precio usuario);
	List<Precio> getPrecios();
	Optional<Precio> getById(int id);
	String update(PrecioDTO precio,int id);
}
