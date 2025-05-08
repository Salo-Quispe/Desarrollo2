package com.msqs.dsa.tienda.controller;

import com.msqs.dsa.tienda.entity.DetallePedido;
import com.msqs.dsa.tienda.entity.Pedido;
import com.msqs.dsa.tienda.service.ServiceDetalle;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle")
public class ControllerDetalle {
    private final ServiceDetalle servicio;

    public ControllerDetalle(ServiceDetalle servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public DetallePedido crear(@RequestBody DetallePedido pd) {
        return servicio.guardarDetalle(pd);
    }

    @GetMapping
    public List<DetallePedido> listar() {
        return servicio.listarDetalle();
    }
}