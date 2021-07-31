package com.netec.tienda.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netec.tienda.clients.IArticuloFeign;
import com.netec.tienda.entities.Articulo;
import com.netec.tienda.entities.Carrito;

@Service
public class CarritoServiceImpl implements ICarritoService{
	
	@Autowired
	private IArticuloFeign feign;
	private Carrito carrito;

	@Override
	public boolean addArticulo(int id) {
		if(carrito==null) {this.carrito= new Carrito();}
		
		Articulo art=feign.findById(id);
		if(art.getId()!=0 && art.getNombre()!=null && art.getMarca()!=null) {
			return this.carrito.getArticulos().add(art);
		}
		
		return false;
	}

	@Override
	public boolean removeArticulo(String nombre) {
		Articulo art= this.carrito.getArticulos().stream()
				.filter(t->t.getNombre().equalsIgnoreCase(nombre))
				.findFirst().orElse(null);
		
		return this.carrito.getArticulos().remove(art);
	}

	@Override
	public List<Articulo> showAll() {
		
		return this.carrito.getArticulos().stream()
				.sorted((a,b)->a.getNombre().compareTo(b.getNombre()))
				.collect(Collectors.toList());
	}

	@Override
	public double getTotal() {
		
		return this.carrito.getArticulos().stream()
				.mapToDouble(t->t.getPrecio()).sum();
	}

}
