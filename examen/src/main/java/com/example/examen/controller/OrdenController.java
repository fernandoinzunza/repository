package com.example.examen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.model.Orden;
import com.example.examen.model.OrdenDTO;
import com.example.examen.service.OrdenServiceImpl;
import com.google.gson.Gson;
@RequestMapping("api/orden")
@RestController
public class OrdenController {
	@Autowired
	OrdenServiceImpl ordenService;
	@GetMapping("/")
	public ResponseEntity<List<Orden>> getOrdenes(){
		return ResponseEntity.ok(ordenService.getOrdenes());
	}
	@PostMapping("/crear")
	public ResponseEntity<String> crear(@RequestBody OrdenDTO orden){
		var res  =ordenService.create(orden);
		
		if(res.getMessage().equals("OK"))
			return ResponseEntity.ok().body(new Gson().toJson(res));
		else
			return ResponseEntity.badRequest().body(new Gson().toJson(res));
	}
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable int id){
		Optional<Orden> obj = ordenService.getById(id);
		if(obj.get() !=null) {
			ordenService.delete(obj.get());
			return ResponseEntity.status(HttpStatus.OK).body("Orden eliminada");
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Orden no encontrada");
	}
	@GetMapping(value = "{id}")
	public ResponseEntity<Orden> getById(@PathVariable int id){
		Optional<Orden> obj = ordenService.getById(id);
		if(obj.isEmpty()) {
			ordenService.delete(obj.get());
			return ResponseEntity.status(HttpStatus.OK).body(obj.get());
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<String> actualizar(@PathVariable int id,@RequestBody OrdenDTO dto){
		var res = ordenService.update(dto, id);
		if(res == "OK")
			return ResponseEntity.ok(res);
		else
			return ResponseEntity.badRequest().body(res);
	}

}
