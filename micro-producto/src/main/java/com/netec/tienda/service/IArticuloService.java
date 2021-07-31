package com.netec.tienda.service;

import java.util.List;

import com.netec.tienda.entities.Articulo;
/*Con esta interfaz podemos controlar la cantidad de métodos
 * que utilizará el controlador*/

public interface IArticuloService {
	Articulo save(Articulo art);
	List<Articulo> findAll();
	List<Articulo> findByMarca(String marca);
	boolean deleteById(int id);
	Articulo findById(int id);
}
