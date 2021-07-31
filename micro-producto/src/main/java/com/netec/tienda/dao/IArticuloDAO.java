package com.netec.tienda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.netec.tienda.entities.Articulo;
/*CrudRepository: Es una interfaz de Spring que utiliza JSQL para
 * realizar operaciones del CRUD*/

public interface IArticuloDAO extends CrudRepository<Articulo, Integer>{
	/*Método para buscar articulos por marca*/
	
	@Query("SELECT u FROM Articulo u WHERE u.marca=:marca")
	List<Articulo> findByMarca(@Param("marca") String marca);
}
