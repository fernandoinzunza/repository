package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.model.Orden;

public interface OrdenRepository extends JpaRepository<Orden,Integer> {

}
