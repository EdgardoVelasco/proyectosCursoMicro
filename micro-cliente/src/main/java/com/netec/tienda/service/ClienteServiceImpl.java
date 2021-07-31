package com.netec.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.netec.tienda.dao.IClienteDAO;
import com.netec.tienda.entities.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteDAO dao;
	
	@Value("${server.port}")
	private int port;

	@Override
	public Cliente save(Cliente cl) {
		
		return dao.save(cl);
	}

	@Override
	public boolean removeById(int id) {
		try {
			dao.deleteById(id);
			return true;
		}catch(Exception ex) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id no existe",ex);	
		}
	}

	@Override
	public Cliente findByEmail(String email) {
	     Cliente cl=dao.findByEmail(email);
	     if(cl!=null) {
	    	 cl.setPort(port);
	     }
	     return cl;
		//return dao.findByEmail(email);
	}

	@Override
	public List<Cliente> findByCiudad(String ciudad) {
		// TODO Auto-generated method stub
		return dao.findByCiudad(ciudad);
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>)dao.findAll();
	}

}
