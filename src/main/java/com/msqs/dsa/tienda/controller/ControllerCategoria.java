package com.msqs.dsa.tienda.controller;

import com.msqs.dsa.tienda.entity.Categoria;
import com.msqs.dsa.tienda.service.ServiceCategoria;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class ControllerCategoria {
    private final ServiceCategoria servicio;

    public ControllerCategoria(ServiceCategoria servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria c) {
        return servicio.guardar(c);
    }

    @GetMapping
    public List<Categoria> listar() {
        return servicio.listar();
    }
}
