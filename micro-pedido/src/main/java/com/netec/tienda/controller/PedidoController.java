package com.netec.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netec.tienda.entities.Pedido;
import com.netec.tienda.service.IPedidoService;

@RestController
public class PedidoController {
	@Autowired
	private IPedidoService servicio;
	
	@PostMapping("/pedido")
	public Pedido addPedido(@RequestBody Pedido p) {
		return servicio.addPedido(p);
	}
	
	@DeleteMapping("/pedido/{id}")
	public boolean deleteById(@PathVariable("id") int id) {
		return servicio.deleteById(id);
	}
	
	@GetMapping("/pedidos")
	public List<Pedido> showAll(){
		return servicio.showAll();
	}
	

}
