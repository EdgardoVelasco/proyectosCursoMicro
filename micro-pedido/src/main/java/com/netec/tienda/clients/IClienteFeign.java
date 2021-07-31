package com.netec.tienda.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.netec.tienda.entities.Cliente;

//@FeignClient(name="micro-cliente", url="http://localhost:8094")
@FeignClient(name="micro-cliente")
public interface IClienteFeign {
	
	@GetMapping("/cliente-e/{email}")
	public Cliente findByEmail(@PathVariable("email") String email);

}
