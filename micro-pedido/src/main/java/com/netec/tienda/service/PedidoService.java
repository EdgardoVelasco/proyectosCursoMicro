package com.netec.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.netec.tienda.clients.IClienteFeign;
import com.netec.tienda.dao.IPedidoDAO;
import com.netec.tienda.entities.Cliente;
import com.netec.tienda.entities.Pedido;

@Service
public class PedidoService implements IPedidoService{
	@Autowired
	private IClienteFeign feign;
	
	@Autowired
	private IPedidoDAO dao;

	@Override
	public Pedido addPedido(Pedido pe) {
	    /*ejecutar a Feign para obtener a un cliente 
	     * del microservicios cliente*/
		Cliente buscar=feign.findByEmail(pe.getCorreoCliente());
		if(buscar!=null) {
			Pedido p=dao.save(pe);
			p.setPort(buscar.getPort());
			return p;
			//return dao.save(pe);
		}
		
		return new Pedido();
	}

	@Override
	public boolean deleteById(int id) {
		try {
			dao.deleteById(id);
			return true;
			
		}catch(Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pedido no existe");
		}
	}

	@Override
	public List<Pedido> showAll() {
		
		return (List<Pedido>)dao.findAll();
	}

}
