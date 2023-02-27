package com.example.examen.service;

import java.util.List;
import java.util.Optional;

import com.example.examen.model.Orden;
import com.example.examen.model.OrdenDTO;
import com.example.examen.model.OrdenResponseDTO;
import com.example.examen.model.Precio;

public interface OrdenService {
	OrdenResponseDTO create(OrdenDTO orden);
	void delete(Orden orden);
	List<Orden> getOrdenes();
	Optional<Orden> getById(int id);
	String update(OrdenDTO orden,int id);
	
}
