package com.example.examen.service;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.examen.model.Orden;
import com.example.examen.model.Precio;
import com.example.examen.repository.OrdenRepository;
import com.example.examen.repository.PrecioRepository;
@ExtendWith(MockitoExtension.class)
public class OrdenServiceTest {
	 @InjectMocks
	    OrdenServiceImpl ordenServicio;
	    @Mock
	    OrdenRepository ordenRepository;
	    @Test
	    public void test(){
	       Optional<Orden> orden = ordenServicio.getById(1);
	        assertNull(orden.get());
	    }
}
