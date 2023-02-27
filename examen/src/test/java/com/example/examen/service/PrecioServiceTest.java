package com.example.examen.service;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.examen.model.Precio;
import com.example.examen.repository.PrecioRepository;

@ExtendWith(MockitoExtension.class)
public class PrecioServiceTest {
    @InjectMocks
    PrecioServiceImpl precioServicio;
    @Mock
    PrecioRepository precioRepository;
    @Test
    public void test(){
       Optional<Precio> precio = precioServicio.getById(1);
        assertNull(precio.get());
    }
}
