package com.msqs.dsa.tienda.service;

import com.msqs.dsa.tienda.entity.Proveedor;
import com.msqs.dsa.tienda.repository.RepositoryProveedor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceProveedor {
    private final RepositoryProveedor repo;

    public ServiceProveedor(RepositoryProveedor repo){
        this.repo = repo;
    }

    public Proveedor guardarProveedor(Proveedor pv){
        return repo.save(pv);
    }

    public List<Proveedor> listarProveedores(){
        return repo.findAll();
    }
}
