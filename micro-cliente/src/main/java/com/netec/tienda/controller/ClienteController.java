package com.netec.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netec.tienda.entities.Cliente;
import com.netec.tienda.service.IClienteService;

@RestController
public class ClienteController {
	@Autowired
	private IClienteService servicio;
	
	
	@PostMapping("/cliente")
	public Cliente save(@RequestBody Cliente cl) {
		return servicio.save(cl);
	}
	
	@GetMapping("/cliente-e/{email}")
	public Cliente findByEmail(@PathVariable("email") String email) {
		return servicio.findByEmail(email);
	}
	
	@GetMapping("/cliente-c/{ciudad}")
	public List<Cliente> findByCiudad(@PathVariable("ciudad") String ciudad){
		return servicio.findByCiudad(ciudad);
	}
	
	@DeleteMapping("/cliente/{id}")
	public boolean removeById(@PathVariable("id") int id) {
		return servicio.removeById(id);
	}
	
	@GetMapping("/cliente")
	public List<Cliente> showAll(){
	   return servicio.findAll();
	
	}

}
