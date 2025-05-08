package com.msqs.dsa.tienda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.msqs.dsa.tienda.entity.Producto;
import com.msqs.dsa.tienda.service.ServicesProduct;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ControllerProduct {

    private final ServicesProduct servicio;

    public ControllerProduct(ServicesProduct servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestParam double precioOriginal,
                                                  @RequestParam String categoria,
                                                  @RequestParam Long proveedorId) {
        Producto producto = servicio.crearProducto(precioOriginal, categoria, proveedorId);
        return ResponseEntity.ok(producto);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(servicio.listar());
    }

    // 🟦 Endpoint 1: Productos ordenados por precio final (descendente)
    @GetMapping("/ordenados-precio")
    public ResponseEntity<List<Producto>> listarOrdenadosPorPrecioFinal() {
        return ResponseEntity.ok(servicio.listarProductosOrdenadosPorPrecioFinal());
    }

    // 🟦 Endpoint 2: Buscar productos por categoría (por nombre)
    @GetMapping("/por-categoria")
    public ResponseEntity<List<Producto>> buscarPorCategoria(@RequestParam String nombreCategoria) {
        return ResponseEntity.ok(servicio.buscarPorCategoria(nombreCategoria));
    }

    // 🟦 Endpoint 3: Buscar productos cuyo precio final sea mayor a cierto valor
    @GetMapping("/mayor-a")
    public ResponseEntity<List<Producto>> buscarPorPrecioMayorA(@RequestParam double precio) {
        return ResponseEntity.ok(servicio.buscarPorPrecioMayorA(precio));
    }
}
