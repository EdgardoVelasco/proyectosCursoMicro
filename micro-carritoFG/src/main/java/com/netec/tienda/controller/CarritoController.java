package com.netec.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netec.tienda.entities.Articulo;
import com.netec.tienda.service.ICarritoService;

@RestController
public class CarritoController {
	
	@Autowired
	private ICarritoService servicio;
	
	@PutMapping("/carrito/{id}")
	public boolean addArticulo(@PathVariable("id") int id) {
		return servicio.addArticulo(id);
	}
	
	@DeleteMapping("/carrito/{nombre}")
	public boolean removeArticulo(@PathVariable("nombre") String nombre) {
		return servicio.removeArticulo(nombre);
	}
	
	@GetMapping("/carrito")
	public List<Articulo> showAll(){
		return servicio.showAll();
	}
	
	@GetMapping("/carrito-t")
	public double getTotal() {
		return servicio.getTotal();
	}
	

}
