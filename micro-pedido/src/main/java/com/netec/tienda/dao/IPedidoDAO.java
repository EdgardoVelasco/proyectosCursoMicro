package com.netec.tienda.dao;

import org.springframework.data.repository.CrudRepository;

import com.netec.tienda.entities.Pedido;

public interface IPedidoDAO extends CrudRepository<Pedido, Integer>{

}
