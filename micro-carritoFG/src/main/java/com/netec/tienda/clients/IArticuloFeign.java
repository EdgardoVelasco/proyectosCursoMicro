package com.netec.tienda.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.netec.tienda.entities.Articulo;

/*@FeignClient: Es una anotacion que le indica a Spring que esta 
 * interface se va a conectar a un microservicio usando Feign
 * */

//@FeignClient(name="micro-articulo", url="http://localhost:8090")

/*El url se quita sólo si configuramos a Ribbon o a Eureka
 * */
@FeignClient(name="micro-articulo")
public interface IArticuloFeign {
	
	@GetMapping("/articulo/{id}")
	public Articulo findById(@PathVariable("id") int id);
	
	@GetMapping("/articulos")
	public List<Articulo> findAll();

}
