package com.netec.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/*RestController: Le indica a Spring que esta  clase 
 * se registrará cómo un  controlador. 
 * Un elemento importante de esta anotación es que mapea el retorno
 * de los métodos a formato JSON*/

import com.netec.tienda.entities.Articulo;
import com.netec.tienda.service.IArticuloService;

/*Dentro de esta clase se mapearan los métodos de nuestro servicio
 * a métodos de HTTP (GET, POST, PUT, DELETE)*/

@RestController
public class ArticuloController {
	/*Antes*/
	//private IArticuloService servicio= new ArticuloServiceImpl();
	/*Ahora*/
	@Autowired
	private IArticuloService servicio;
	
	@PostMapping("/articulo") //(POST)http://localhost:8090/articulo
	public Articulo save(@RequestBody Articulo art) {
		return servicio.save(art);
	}
	
	@GetMapping("/articulos") //(GET)http://localhost:8090/articulos
	public List<Articulo> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/articulos/{marca}") //(GET)http://localhost:8090/articulos/marca
	public List<Articulo> findByMarca(@PathVariable("marca") String marca){
		return servicio.findByMarca(marca);
	}
	
	@DeleteMapping("/articulo/{id}")//(DELETE) http://localhost:8090/articulo/id
	public boolean deleteById(@PathVariable("id") int id) {
		return servicio.deleteById(id);
	}
	
	@GetMapping("/articulo/{id}")//(GET)http://localhost:8090/articulo/id
	public Articulo findById(@PathVariable("id") int id) {
		return servicio.findById(id);
	}

}
