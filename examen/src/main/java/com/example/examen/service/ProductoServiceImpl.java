package com.example.examen.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.model.Producto;
import com.example.examen.model.ProductoDTO;
import com.example.examen.model.Usuario;
import com.example.examen.repository.ProductoRepository;
@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository productRepository;
	@Override
	public Producto create(Producto producto) {
		// TODO Auto-generated method stub
		return productRepository.save(producto);
	}

	@Override
	public void delete(Producto producto) {
		// TODO Auto-generated method stub
		productRepository.delete(producto);
	}

	@Override
	public List<Producto> getProductos() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Optional<Producto> getById(int id) {
		// TODO Auto-generated method stub
		var p= productRepository.findById(id);
		if(!p.isEmpty())
			return null;
		return p;
		
	}

	@Override
	public String update(ProductoDTO producto, int id) {
		// TODO Auto-generated method stub
		Optional<Producto> product = productRepository.findById(id);
		Producto prod= product.get();
		if(product !=null)
		{
			if(producto.getNombre() !=null)
			prod.setNombre(prod.getNombre());
			if(producto.getPrecio()!=null)
			prod.setPrecio(new BigDecimal(producto.getPrecio()));
			if(producto.getStock()!=null)
			prod.setStock(producto.getStock());
			productRepository.save(prod);
			return "OK";
		}
		else
			return "No existe el producto";
	}

}
