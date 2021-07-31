package com.netec.tienda.service;

import java.util.List;

import com.netec.tienda.entities.Articulo;

public interface ICarritoService {
	boolean addArticulo(int id);
	boolean removeArticulo(String nombre);
	List<Articulo> showAll();
	double getTotal();
}
