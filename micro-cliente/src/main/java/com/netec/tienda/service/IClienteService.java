package com.netec.tienda.service;

import java.util.List;

import com.netec.tienda.entities.Cliente;

public interface IClienteService {
    Cliente save(Cliente cl);
    boolean removeById(int id);
    Cliente findByEmail(String email);
    List<Cliente> findByCiudad(String ciudad);
    List<Cliente> findAll();

}
