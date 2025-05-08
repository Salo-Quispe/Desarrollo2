package com.msqs.dsa.tienda.service;

import com.msqs.dsa.tienda.entity.Categoria;
import com.msqs.dsa.tienda.repository.RepositoryCategoria;
import org.springframework.stereotype.*;

import java.util.List;

@Service
public class ServiceCategoria {
    private final RepositoryCategoria repo;

    public ServiceCategoria(RepositoryCategoria repo) {
        this.repo = repo;
    }

    public Categoria guardar(Categoria c) {
        return repo.save(c);
    }

    public List<Categoria> listar() {
        return repo.findAll();
    }
}
