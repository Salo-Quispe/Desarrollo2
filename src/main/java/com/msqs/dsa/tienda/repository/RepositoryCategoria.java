package com.msqs.dsa.tienda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msqs.dsa.tienda.entity.Categoria;

public interface RepositoryCategoria extends JpaRepository<Categoria, Long>{
	Optional<Categoria> findByNombreIgnoreCase(String nombre);
}
