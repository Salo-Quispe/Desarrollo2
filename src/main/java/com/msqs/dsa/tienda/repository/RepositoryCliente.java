package com.msqs.dsa.tienda.repository;

import com.msqs.dsa.tienda.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCliente extends JpaRepository<Cliente, Long> { }
