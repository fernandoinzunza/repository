package com.example.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.model.OrdenProducto;

public interface OrdenProductoRepository extends JpaRepository<OrdenProducto,Integer> {
	List<OrdenProducto> findByOrdenId(int orden_id);
}
