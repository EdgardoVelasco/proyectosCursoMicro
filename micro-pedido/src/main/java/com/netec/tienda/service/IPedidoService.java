package com.netec.tienda.service;

import java.util.List;

import com.netec.tienda.entities.Pedido;

public interface IPedidoService { 
	Pedido addPedido(Pedido pe);
	boolean deleteById(int id);
	List<Pedido> showAll();
}
