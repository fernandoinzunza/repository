package com.example.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.examen.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}
