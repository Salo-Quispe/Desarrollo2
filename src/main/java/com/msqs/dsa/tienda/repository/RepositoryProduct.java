package com.msqs.dsa.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msqs.dsa.tienda.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepositoryProduct extends JpaRepository<Producto, Long>{
    @Query("SELECT p FROM Producto p ORDER BY p.precioFinal DESC")
    List<Producto> findAllOrderByPrecioFinalDesc();

    @Query("SELECT p FROM Producto p WHERE p.categoria.nombre = :nombreCategoria")
    List<Producto> findByNombreCategoria(@Param("nombreCategoria") String nombreCategoria);

    @Query("SELECT p FROM Producto p WHERE p.precioFinal > :precio")
    List<Producto> findByPrecioFinalMayorA(@Param("precio") double precio);
}
