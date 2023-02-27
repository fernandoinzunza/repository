package com.example.examen.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.examen.model.Producto;
import com.example.examen.repository.ProductoRepository;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class ProductoServiceTest {
    @InjectMocks
    ProductoServiceImpl productoServicio;
    @Mock
    ProductoRepository productoRepository;
    @Test
    public void test(){
       Optional<Producto> producto = productoServicio.getById(1);
        assertNull(producto.get());
    }
}
