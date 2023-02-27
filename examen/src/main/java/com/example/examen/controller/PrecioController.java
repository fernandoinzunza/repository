package com.example.examen.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.examen.model.Precio;
import com.example.examen.model.PrecioDTO;
import com.example.examen.service.PrecioServiceImpl;
@RequestMapping("api/precio")
@RestController
public class PrecioController {
	@Autowired
	PrecioServiceImpl precioService;
	@GetMapping("/")
	public ResponseEntity<List<Precio>> getPrecios(){
		return ResponseEntity.ok(precioService.getPrecios());
	}
	@PostMapping("/nuevoPrecio")
	public ResponseEntity<Precio> nuevo(@RequestBody PrecioDTO p){
		Precio pre = new Precio();
		pre.setPrecio(new BigDecimal(p.getValor().toString()));
		return ResponseEntity.ok(precioService.create(pre));
	}
	@PostMapping
	public ResponseEntity<Precio> crear(@RequestBody(required = false) PrecioDTO precio){
		Precio p = new Precio();
		p.setPrecio(new BigDecimal(precio.getValor()));
		return ResponseEntity.ok(precioService.create(p));
	}
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable int id){
		Optional<Precio> obj = precioService.getById(id);
		if(obj.get() !=null) {
			precioService.delete(obj.get());
			return ResponseEntity.status(HttpStatus.OK).body("Precio eliminado");
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Precio no encontrado");
	}
	@GetMapping(value = "{id}")
	public ResponseEntity<Precio> getById(@PathVariable int id){
		Optional<Precio> obj = precioService.getById(id);
		if(obj.get() !=null) {
			precioService.delete(obj.get());
			return ResponseEntity.status(HttpStatus.OK).body(obj.get());
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
}
