package com.msqs.dsa.tienda.service;

import com.msqs.dsa.tienda.entity.DetallePedido;
import com.msqs.dsa.tienda.repository.RepositoryDetalle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDetalle {
    private final RepositoryDetalle repo;

    public ServiceDetalle(RepositoryDetalle repo){
        this.repo=repo;
    }
    public DetallePedido guardarDetalle(DetallePedido dp){
        return repo.save(dp);
    }
    public List<DetallePedido> listarDetalle(){
        return repo.findAll();
    }
}
