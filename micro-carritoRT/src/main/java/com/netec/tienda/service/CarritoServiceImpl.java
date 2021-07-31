package com.netec.tienda.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netec.tienda.entities.Articulo;
import com.netec.tienda.entities.Carrito;

@Service
public class CarritoServiceImpl implements ICarritoService {
	@Autowired
	private RestTemplate templete;
	private Carrito carrito;

	@Override
	public boolean addArticulo(int id) { 
		boolean resp=false;
		if(carrito==null) {this.carrito= new Carrito();}
		
		/*Se prepara un Map para enviar datos a través de RestTemplate*/
		Map<String, String> mapa=new HashMap<>();
		mapa.put("id", String.valueOf(id));
		
		/*Usamos a restTemplete para obtener el resultado del micro-articulo*/
		String url="http://localhost:8090/articulo/{id}";
		Articulo art= templete.getForObject(url, Articulo.class, mapa);
		
		/*Validamos si existe el articulo*/
		if(art.getId()!=0 && art.getNombre()!=null && art.getMarca()!=null) {
			return this.carrito.getArticulos().add(art);
		}
		
		return resp;
	}

	@Override
	public boolean deleteArticulo(String nombre) {
		Articulo encontrado= this.carrito.getArticulos().stream()
				                .filter(t->t.getNombre().equalsIgnoreCase(nombre))
				                .findFirst().orElse(null);
	    
		return this.carrito.getArticulos().remove(encontrado);
	}

	@Override
	public List<Articulo> showAll() {
		/*Stream*/
		return this.carrito.getArticulos().stream()
				.sorted((a,b)->((Double)a.getPrecio()).compareTo(b.getPrecio()))
				.collect(Collectors.toList());
				
	}

	@Override
	public double getTotal() {
		
		return this.carrito.getArticulos().stream()
				.mapToDouble(t->t.getPrecio()).sum();
	}

}
