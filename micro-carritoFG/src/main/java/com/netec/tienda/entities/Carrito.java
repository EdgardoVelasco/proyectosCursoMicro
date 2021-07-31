package com.netec.tienda.entities;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private List<Articulo> articulos;
	
	public Carrito() {
		this.articulos= new ArrayList<>();
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

}
