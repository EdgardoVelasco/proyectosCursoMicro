package com.netec.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.netec.tienda.dao.IArticuloDAO;
import com.netec.tienda.entities.Articulo;

/*@Service: Le indica a Spring que esta clase es un servicio*/

@Service
public class ArticuloServiceImpl implements IArticuloService {
	/*Antes*/
	//private IArticuloDAO dao=new IArticuloDAO() {};
	
	/*Ahora*/
	@Autowired
	private IArticuloDAO dao;
	
	/*@Value: extraer el puerto de la configuración de Spring
	 * y se lo asigna al atributo port.
	 * */
	@Value("${server.port}")
	private int port;

	@Override
	public Articulo save(Articulo art) {
		
		return dao.save(art);
	}

	@Override
	public List<Articulo> findAll() {
		
		return (List<Articulo>)dao.findAll(); /*Iterable<T>*/
	}

	@Override
	public List<Articulo> findByMarca(String marca) {
		
		return dao.findByMarca(marca);
	}

	@Override
	public boolean deleteById(int id) {
		try {
		   dao.deleteById(id);
		   return true;
		}catch(Exception ex) {
		  throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				  "No se encuentra el articulo", ex);	
		}
	}

	@Override
	public Articulo findById(int id) {
		Articulo art= dao.findById(id).orElse(new Articulo());
		if(art.getId()!=0) {
			art.setPort(port);
		}
		
		return art;
		//return dao.findById(id).orElse(new Articulo());
	}

}
