package com.msqs.dsa.tienda.repository;

import com.msqs.dsa.tienda.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryPedido extends JpaRepository<Pedido, Long> {
    @Query("SELECT p FROM Pedido p JOIN FETCH p.detalles")
    List<Pedido> findAllPedidosConDetalles();

    @Query("SELECT p FROM Pedido p WHERE p.cliente.nombre = :nombreCliente")
    List<Pedido> findByClienteNombre(@Param("nombreCliente") String nombreCliente);
}