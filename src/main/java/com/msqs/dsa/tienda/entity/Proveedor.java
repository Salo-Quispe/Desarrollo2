package com.msqs.dsa.tienda.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String contacto;

    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;

    // Getters y Setters
}

