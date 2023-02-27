package com.example.examen.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.model.Precio;
import com.example.examen.model.PrecioDTO;
import com.example.examen.model.Producto;
import com.example.examen.repository.PrecioRepository;
@Service
public class PrecioServiceImpl implements PrecioService {
	@Autowired
	private PrecioRepository precioRepository;
	@Override
	public Precio create(Precio precio) {
		// TODO Auto-generated method stub
		return precioRepository.save(precio);
	}

	@Override
	public void delete(Precio precio) {
		// TODO Auto-generated method stub
		precioRepository.delete(precio);
		
	}

	@Override
	public List<Precio> getPrecios() {
		// TODO Auto-generated method stub
		return precioRepository.findAll();
	}

	@Override
	public Optional<Precio> getById(int id) {
		// TODO Auto-generated method stub
		var p = precioRepository.findById(id);
		if(p.isEmpty())
			return null;
		return p;
	}

	@Override
	public String update(PrecioDTO precio, int id) {
		// TODO Auto-generated method stub
		Optional<Precio> obj = precioRepository.findById(id);
		Precio p= obj.get();
		if(p !=null)
		{
			p.setPrecio(new BigDecimal(precio.getValor()));
			precioRepository.save(p);
			return "OK";
		}
		else
			return "No existe el precio";
	}

}
