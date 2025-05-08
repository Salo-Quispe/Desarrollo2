package com.msqs.dsa.tienda.service;

import com.msqs.dsa.tienda.entity.Cliente;
import com.msqs.dsa.tienda.repository.RepositoryCliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCliente {
    private final RepositoryCliente repo;

    public ServiceCliente(RepositoryCliente repo){
        this.repo=repo;
    }

    public Cliente guadarCliente(Cliente cl){
        return repo.save(cl);
    }
    public List<Cliente> listarClientes(){
        return repo.findAll();
    }
}