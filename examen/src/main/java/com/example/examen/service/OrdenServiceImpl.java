package com.example.examen.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.model.Orden;
import com.example.examen.model.OrdenDTO;
import com.example.examen.model.OrdenProducto;
import com.example.examen.model.OrdenProductoDTO;
import com.example.examen.model.OrdenResponseDTO;
import com.example.examen.model.Producto;
import com.example.examen.repository.OrdenProductoRepository;
import com.example.examen.repository.OrdenRepository;
import com.example.examen.repository.PrecioRepository;
import com.example.examen.repository.ProductoRepository;
@Service
public class OrdenServiceImpl implements OrdenService {
	@Autowired
	private OrdenRepository ordenRepository;
	@Autowired
	private OrdenProductoRepository oProductoRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Override
	public OrdenResponseDTO create(OrdenDTO orden) {

		OrdenResponseDTO dto = new OrdenResponseDTO();
		Orden or = new Orden();
		double total = 0;
		for(OrdenProductoDTO o : orden.getProductos()){
			Optional<Producto> p = productoRepository.findById(o.getProducto_id());
			if(p.isEmpty()) {
				dto.setMessage("No existe el producto con id "+o.getProducto_id());
				dto.setOrden(null);
				return dto;
			}
				
			Producto prod = null;
			prod = p.get();
			if(prod.getStock() < o.getCantidad()) {
				dto.setMessage("No hay suficiente stock para el producto con id "+o.getProducto_id());
				dto.setOrden(null);				
			}
			total+=prod.getPrecio().doubleValue();
			}
		or.setTotal(new BigDecimal(String.valueOf(total)));
		or.setUsuario_id(orden.getUsuario_id());
		or.setFecha_creacion(new Date());
		var ord = ordenRepository.save(or);
		for(OrdenProductoDTO o : orden.getProductos()){
		OrdenProducto op = new OrdenProducto();
			op.setOrden_Id(ord.getId());
			op.setProducto_id(o.getProducto_id());
			op.setCantidad(o.getCantidad());
			op.setFecha_creacion(new Date());
			oProductoRepository.save(op);	
			
		}
		List<OrdenProducto> oprod = oProductoRepository.findByOrdenId(ord.getId());
		ord.setProductos(oprod);
		dto.setOrden(ord);
		dto.setMessage("OK");
		return dto;
	}

	@Override
	public void delete(Orden orden) {
		// TODO Auto-generated method stub
		List<OrdenProducto> productos = oProductoRepository.findByOrdenId(orden.getId());
		for(OrdenProducto o:productos)
		{
			oProductoRepository.delete(o);
		}
		ordenRepository.delete(orden);
		
	}

	@Override
	public List<Orden> getOrdenes() {
		// TODO Auto-generated method stub
		return ordenRepository.findAll();
	}

	@Override
	public Optional<Orden> getById(int id) {
		// TODO Auto-generated method stub
	
		var o = ordenRepository.findById(id);
		if(!o.isEmpty())
			return o;
		else
			return null;
	}

	@Override
	public String update(OrdenDTO orden, int id) {
		Optional<Orden>ord = ordenRepository.findById(id);
		if(ord.isEmpty())
			return "No existe la orden";
		Orden obj = ord.get();
		if(orden.getUsuario_id() !=null)
			obj.setUsuario_id(orden.getUsuario_id());
		if(orden.getProductos() !=null)
		{
			List<OrdenProducto> oprod = oProductoRepository.findByOrdenId(id);
			for(OrdenProducto p:oprod)
			{
				oProductoRepository.delete(p);
			}
			for(OrdenProductoDTO p:orden.getProductos())
			{
				OrdenProducto o = new OrdenProducto();
				o.setCantidad(p.getCantidad());
				o.setFecha_creacion(new Date());
				o.setOrden_Id(id);
				o.setProducto_id(p.getProducto_id());
				oProductoRepository.save(o);
			}
		}
		return "OK";
	}

}
