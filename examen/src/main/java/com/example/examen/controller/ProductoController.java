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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.model.Producto;
import com.example.examen.model.ProductoDTO;
import com.example.examen.model.Usuario;
import com.example.examen.model.UsuarioDTO;
import com.example.examen.service.ProductoServiceImpl;
import com.example.examen.service.UsuarioServiceImpl;
@RequestMapping("api/producto")
@RestController
public class ProductoController {
	@Autowired
	private ProductoServiceImpl productoService;
	
	@GetMapping("/")
	public ResponseEntity<List<Producto>> getProductos()
	{
		return ResponseEntity.ok(productoService.getProductos());
	}
	@PostMapping("/crear")
	public ResponseEntity<Producto> create(@RequestBody ProductoDTO producto){
		Producto obj = new Producto();
		if(producto.getNombre() != null)
		obj.setNombre(producto.getNombre());
		if(producto.getPrecio() !=null)
		obj.setPrecio(new BigDecimal(producto.getPrecio()));
		if(producto.getStock() !=null)
		obj.setStock(producto.getStock());
		Producto res =productoService.create(obj);
		return ResponseEntity.ok(res);
	}
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		Optional<Producto> obj = productoService.getById(id);
		if(obj.get() !=null) {
			productoService.delete(obj.get());
			return ResponseEntity.status(HttpStatus.OK).body("Producto eliminado");
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
	}
	@GetMapping(value = "{id}")
	public ResponseEntity<Optional<Producto>> getById(@PathVariable int id){
		return ResponseEntity.ok(productoService.getById(id));
	}
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<String> actualizar(@PathVariable int id,@RequestBody ProductoDTO dto){
		var res = productoService.update(dto, id);
		if(res == "OK")
			return ResponseEntity.ok(res);
		else
			return ResponseEntity.badRequest().body(res);
	}
}
