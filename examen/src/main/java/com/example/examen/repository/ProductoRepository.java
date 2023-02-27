package com.example.examen.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.model.Producto;
public interface ProductoRepository extends JpaRepository<Producto,Integer>{

}
