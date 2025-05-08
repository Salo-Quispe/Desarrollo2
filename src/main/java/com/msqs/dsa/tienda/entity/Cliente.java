package com.msqs.dsa.tienda.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    // Getters y Setters
}

