package com.example.examen.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.model.Precio;

public interface PrecioRepository extends JpaRepository<Precio,Integer> {

}
