package com.msqs.dsa.tienda.repository;

import com.msqs.dsa.tienda.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryDetalle extends JpaRepository<DetallePedido, Long> { }
