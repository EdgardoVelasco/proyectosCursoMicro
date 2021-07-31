package com.netec.tienda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.netec.tienda.entities.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Integer> {
	@Query("SELECT u FROM Cliente u WHERE u.email=:email")
	Cliente findByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM Cliente u WHERE u.ciudadOrigen=:ciudad")
	List<Cliente> findByCiudad(@Param("ciudad") String ciudad);

}
